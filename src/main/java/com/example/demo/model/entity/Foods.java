package com.example.demo.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "foods")
public class Foods {
	/**
	 * 食品情報
	 */

	// ID
	@Column(name = "id", nullable = false)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	// 名前
	@Column(name = "name", nullable = false, length = 100)
	private String name;

	// 数量
	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	// 作成日時
	@Column(name = "create_at", nullable = false)
	private LocalDateTime createAt;

	// 更新日時
	@Column(name = "update_at", nullable = false)
	private LocalDateTime updateAt;
}
