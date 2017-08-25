package com.memorynotfound.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.memorynotfound.model.City;

@Controller
public class CityController {
	
	private List<City> cities = Arrays.asList(
		new City("101", "Bandung", "Jawa Barat"),
		new City("201", "Yogya", "Jawa Tengah"),
		new City("302", "Jember", "Jawa Timur")
	);
	
	@RequestMapping("/cities")
	public String getCity(Model model) {
		model.addAttribute("viewName", "cities");
		model.addAttribute("cities", cities);
		return "cities";
	}
}
