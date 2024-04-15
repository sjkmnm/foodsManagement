package com.example.demo.model.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Foods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class FoodsDao {
	@Autowired
	EntityManager em;

	/**
	 * 食品一覧を取得
	 *
	 * @return Foods 食品一覧
	 */
	@SuppressWarnings("unchecked")
	public List<Foods> getFoodsList() {

		String query = "";
		query += "SELECT * ";
		query += "FROM foods ";
		query += "WHERE is_delete = false";

		return em.createNativeQuery(query, Foods.class).getResultList();
	}
	
	/**
     * IDから該当する食品情報を取得
     *
     * @param id
     * @return Foods
     */
    public Foods findFoodById(String id) {
        String query = "";
        query += "SELECT * ";
        query += "FROM foods ";
        query += "WHERE id = :id AND is_delete = false";

        return (Foods) em.createNativeQuery(query, Foods.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
    /**
     * 食品を登録
     *
     * @param food 食品情報
     */
    public void registerFood(Foods food) {
        // 食品を登録
        em.persist(food);
    }
    
    /**
     * 食品情報を更新
     *
     * @param food 食品情報
     */
    public void updateFood(Foods food) {
        // 食品情報更新
        Query query = em.createNativeQuery(
                "UPDATE foods SET name = :name, quantity = :quantity, update_at = :updateDate WHERE id = :id");
        query.setParameter("id", food.getId());
        query.setParameter("name", food.getName());
        query.setParameter("quantity", food.getQuantity());
        query.setParameter("updateDate", LocalDateTime.now());
        query.executeUpdate();
    }

    /**
     * 食品を論理削除
     *
     * @param id
     */
    public void deleteFood(String id) {
        // 食品情報の削除フラグを更新
    	Query query = em.createNativeQuery(
                "UPDATE foods SET is_delete = true, update_at = :updateDate WHERE id = :id");
    	query.setParameter("id", id);
        query.setParameter("updateDate", LocalDateTime.now());
        query.executeUpdate();
    }
}
