package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.FoodEntryForm;
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
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("new");
		return mav;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView registerPost(@ModelAttribute("registerForm") FoodEntryForm registerForm, ModelAndView mav) {
		Foods food = new Foods();
		food.setName(registerForm.getName());
		food.setQuantity(registerForm.getQuantity());
		food.setCreateAt(LocalDateTime.now());
		food.setUpdateAt(LocalDateTime.now());
		
		indexService.registerFood(food);
		mav.setViewName("redirect:top");
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") String id, ModelAndView mav) {
		Foods food = indexService.getFoodById(id);
		mav.addObject("editForm", food);
		mav.setViewName("edit");
		return mav;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editPost(@ModelAttribute("editForm") FoodEntryForm editForm, ModelAndView mav) {
		Foods food = new Foods();
		food.setId(editForm.getId());
		food.setName(editForm.getName());
		food.setQuantity(editForm.getQuantity());
		indexService.updateFood(food);
		mav.setViewName("redirect:top");
		return mav;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deletePost(String id, ModelAndView mav) {
		indexService.deleteFood(id);
		mav.setViewName("redirect:top");
		return mav;
	}
}
