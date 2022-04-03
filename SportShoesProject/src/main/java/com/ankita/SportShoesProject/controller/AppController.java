package com.ankita.SportShoesProject.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ankita.SportShoesProject.entity.User;
import com.ankita.SportShoesProject.repo.UserRepository;


@Controller
public class AppController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserRepository repo;
	
	@GetMapping("")
	public String viewHomePage()
	{
		return "index";
	}
	
	@GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "signup_form";
    }
	
	@PostMapping("/process_register")
	public String processRegistration(User user)
	{
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    	String encodedPassword=encoder.encode(user.getPassword());
    	user.setPassword(encodedPassword);
		repo.save(user);
		return "register_success";
	}

	@GetMapping("/user")
	public String userPage()
	{
		return "userdashboard";
	}
	
	@GetMapping("/admin")
	public String adminPage()
	{
		return "admindashboard";
	}
	
	@GetMapping("/usersbyemail")
	public User findByEmail(String email)
	{
		return repo.findByEmail(email);
	}
	
	@GetMapping("/allusers")
	public String GetAllUsers(Model model)
	{
        List<User> listUsers = repo.findAll();
        model.addAttribute("listUsers", listUsers);
         
        return "alluserslist";
    }
	
	
	/*
	 * @GetMapping("/searchusersbyemail") public User findUserByEmail(String email)
	 * { User userEmail = repo.findByEmail(email);
	 * 
	 * return "alluserslist";
	 * 
	 * }
	 */
	
	@RequestMapping("/searchusersbyemail")
	public String searchUserPage()
	{
		return "searchUserPage";
	}
	
	@RequestMapping("/searchusersbyemailid")
	public ModelAndView findUserByEmail(@RequestParam String email)
	{
		
		  ModelAndView mv=new ModelAndView("userByEmailPage"); 
		  List<User> useremail=repo.findByEmailId(email);
		  mv.addObject("useremail",useremail); 
		  return mv;
		 
		
	}
	
	
	@GetMapping("/changepass")
	public String changepass()
	{
		return "changepasspage";
	}
	
	@GetMapping("/changepassword")
	public String changepassword(@RequestParam("oldpass") String oldpass, @RequestParam("newpass") String newpass, Principal principal, HttpSession session)
	{
		
		  String email=principal.getName(); 
		  User currentUser=this.repo.getUserByEmail(email);
		  
		  if(this.bCryptPasswordEncoder.matches(oldpass, currentUser.getPassword())) 
		  {
			  currentUser.setPassword(this.bCryptPasswordEncoder.encode(newpass));
			  this.repo.save(currentUser);
		  } 
		  
		  else 
		  { 
			  System.out.print("Wrong"); 
		}
		 
		
		return "changedPassSuccessfully";
	}
	
}
