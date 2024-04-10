package com.example.demo.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Foods;

import jakarta.persistence.EntityManager;

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

		return em.createNativeQuery(query, Foods.class).getResultList();
	}
}
