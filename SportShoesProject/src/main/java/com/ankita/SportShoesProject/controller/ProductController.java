package com.ankita.SportShoesProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ankita.SportShoesProject.entity.Product;
import com.ankita.SportShoesProject.repo.ProductRepository;


@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepo;

	@GetMapping("/allproducts")
	public String getAllProducts(Model model)
	{
		List<Product> listproducts=productRepo.findAll();
		model.addAttribute("listproducts",listproducts);
		return "allproducts";
	}
	
	
	
}
