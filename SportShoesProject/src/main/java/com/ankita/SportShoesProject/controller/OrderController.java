package com.ankita.SportShoesProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ankita.SportShoesProject.entity.Order;
import com.ankita.SportShoesProject.repo.OrderRepository;

@Controller
public class OrderController {
	

	@Autowired
	private OrderRepository orderRepo;
	
	@GetMapping("/allpurchasedproducts")
	public String getAllPurchasedProducts(Model model)
	{
		List<Order> listorders=orderRepo.findAll();
		model.addAttribute("listorders",listorders);
		return "allpurchasedlist";
	}
	
	@GetMapping("/productdate")
	public String viewsearchbydatepage()
	{
		return "productbydatepage";
	}
	
	
	@RequestMapping("/productdatesearch")
	public ModelAndView viewsearchbydate(@RequestParam String date)
	{
		ModelAndView mv=new ModelAndView("productDateSearch"); 
		List<Order> listorder =orderRepo.findByDate(date);
		mv.addObject("listorder",listorder); 
		return mv;
		
	}
	
	@GetMapping("/productcategory")
	public String viewSearchByCategoryPage()
	{
		return "productByCategoryPage";
	}
	
	
	@RequestMapping("/productcategorysearch")
	public ModelAndView viewSearchByCategory(@RequestParam String category)
	{
		ModelAndView mv=new ModelAndView("productCategorySearch"); 
		List<Order> listorder =orderRepo.findByCategory(category);
		mv.addObject("listorder",listorder); 
		return mv;
		
	}
}
