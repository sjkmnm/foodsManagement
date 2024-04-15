package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.FoodsDao;
import com.example.demo.model.entity.Foods;

@Service
@Transactional
public class IndexService {
	@Autowired
	FoodsDao foodsdao;

	/**
	 * 食品一覧を取得
	 *
	 * @return Foods 食品一覧
	 */
	public List<Foods> getFoodsList() {
		return foodsdao.getFoodsList();
	}
	
	/**
     * IDから該当する食品情報を取得
     *
     * @param id
     * @return Foods
     */
    public Foods getFoodById(String id) {
        return foodsdao.findFoodById(id);
    }
    
    /**
     * 食品を登録
     *
     * @param food 食品情報
     */
    @Transactional
    public void registerFood(Foods food) {
    	foodsdao.registerFood(food);
    }
    
    /**
     * 食品情報を更新
     *
     * @param food 食品情報
     */
    @Transactional
    public void updateFood(Foods food) {
    	foodsdao.updateFood(food);
    }
    
    /**
     * 食品を削除
     *
     * @param id
     */
    @Transactional
    public void deleteFood(String id) {
        // アカウント削除
    	foodsdao.deleteFood(id);
    }
}
