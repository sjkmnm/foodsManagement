package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.entity.Foods;

@Controller
public class IndexController {
	
	@Autowired
	IndexService indexService;
	
	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		List<Foods> foods = indexService.getFoodsList();
		mav.addObject("foodsList", foods);
		mav.setViewName("index");
		return mav;
	}
}
