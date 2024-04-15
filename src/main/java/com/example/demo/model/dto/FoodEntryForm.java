package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodEntryForm {
	// ID
	private String id;

	// 食品名
    private String name;

    // 数量
    private Integer quantity;
    
    /**
     * 初期化コンストラクタ
     */
    public static FoodEntryForm init(){

        return new FoodEntryForm(
        		null,
                null,
                null
        );
    }
}
