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

	public List<Foods> getFoodsList() {
		return foodsdao.getFoodsList();
	}
}
