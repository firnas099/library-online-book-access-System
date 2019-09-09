package com.firnas.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.firnas.app.Dao.bookRepo;
import com.firnas.app.Dao.pendingRepo;
import com.firnas.app.Dao.registrationRepo;
import com.firnas.app.enity.boockEntity;
import com.firnas.app.enity.pending;
import com.firnas.app.enity.regitration;


@RestController
public class indexController {
	
	@Autowired
	registrationRepo registrationRepo;
	
	@Autowired
	pendingRepo  pendingRepo;
	
	@Autowired
	bookRepo bookRepo; 
	

//	
//	@RequestMapping("/login")
//	public String loginPage() {
//		
//		return "login.jsp";
//	}
	
	
	@RequestMapping("/login")
	public ModelAndView login() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	
	@RequestMapping("/logout-sucess")
	public String loginout() {
		
		return "logout.jsp";
	}
	
	
	
	
	
	////////////////////////////////////////////////////////////
	
	//this is the default open controller-when u run the project
	@RequestMapping("/")
	public ModelAndView appCOnfig() {
		ModelAndView mv=new ModelAndView("home.html");
		System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		return mv;
	}
	
	@RequestMapping("/regpage")
	public ModelAndView regPage() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	//use registrtion controler post
	//user registratuin controller (if local user then the controller will save the content to free registration data base table
	//if user frorignr then the controller will save the content/data to pending database 
	@PostMapping("/add")
	public ModelAndView save(@ModelAttribute("regitration") regitration regitration ,pending pending ) {
       ModelAndView mv=new ModelAndView();
		
	   if(regitration.getNat().equals("srilanka")) {
		   registrationRepo.save(regitration);
	   }
	   
	   else {
		   pendingRepo.save(pending);
		  mv.setViewName("home");
		   
		  // return "index";
		   
	   }
		   
		   mv.setViewName("home");
		   return mv;
	   
		
		
		
		
		//return"index";
	}
	
	//its get controlle of all fre registrtion members/u can log thr billow url and watch the all free registration members 
	@GetMapping("/admin")
	public ModelAndView adminPage(Model model,@RequestParam(defaultValue="0")int page) {
	ModelAndView mv=new ModelAndView();
		model.addAttribute("data", registrationRepo.findAll(new PageRequest(page, 50)));
		model.addAttribute("currentPage", page);
		mv.setViewName("admin");
		return mv;
	}
	//get for one member based on ID
	@GetMapping("/find")
	@ResponseBody
	public Optional<regitration> findData(Integer id) {
	return	registrationRepo.findById(id);
		
	}
	
	//delt for free registration members based on ID
	@GetMapping("/del")
	public RedirectView delData(Integer id) {
		
		registrationRepo.deleteById(id);
		return new RedirectView("/admin");
	}
	

	//its a get controller of forign pending members..u can type the billow URL and can watch all pending requests
	@GetMapping("/temp")
	public ModelAndView showDta(Model model,@RequestParam(defaultValue="0")int pages) {
	
		ModelAndView mv=new ModelAndView();
		model.addAttribute("dtl", pendingRepo.findAll(new PageRequest(pages, 4)));
		model.addAttribute("currentPage", pages);
		mv.setViewName("pendingRegistration");
		return mv;
}
	
	

	
	//this is the url for client accsess the boock page
	@GetMapping("/bookshow")
	public ModelAndView showBooks(Model model,@RequestParam(defaultValue="0")int page1) {
		ModelAndView mv=new ModelAndView();
		model.addAttribute("data",bookRepo.findAll(new PageRequest(page1, 5)));
		model.addAttribute("currentPage", page1);
		mv.setViewName("blog");
		return mv;
		
		
	}
	
    
	@RequestMapping("/hello")
	public String type(@RequestParam("id") Integer id) {
		
		registrationRepo.deleteById(id);
		return "temp";
	}
	
	@RequestMapping("/ch")
	public String check(@ModelAttribute("regitration")regitration regitration) {
		
		registrationRepo.save(regitration);
		return "admin";
	}
	
	// /myboock is url for admin acess the add boockpage
	@RequestMapping("/book")
	public ModelAndView showBoocj() {
		
		ModelAndView mv=new ModelAndView("book.html");
		
		return mv;
	}
	
	

	@RequestMapping("/searchboock")
	public String showBoockSrch(Model model,@RequestParam("id") Integer id ) {
		
		model.addAttribute("data", registrationRepo.findById(id));
		
		return "admin";
	}
//	@PostMapping("/save")	
//	public ModelAndView aprovReg(regitration regitration ,pending pending ,int id) {
//		
//		ModelAndView mv=new ModelAndView();
//		registrationRepo.save(regitration);
//		pendingRepo.deleteById(id);
//		//mv.setViewName("pendingRegistration");
//		
//		return mv;
//	}
	
	//its the post controller for when u apprual the pending member to access the boock blog
	//so thos controller will save the forign member to free registration table asWellass it will delete the records from pending table
	@PostMapping("/save")
	public RedirectView aprove(regitration regitration,pending pending ,int id) {
		
		registrationRepo.save(regitration);
		pendingRepo.deleteById(id);
		
		
		
		return new RedirectView("/temp");
	}
	
	//get controller for find thr menber of pending bacesd on id
	@RequestMapping("/findtemp")
	@ResponseBody
	public Optional<pending> findTemp(Integer id) {
		
		return pendingRepo.findById(id);
	}
	//delete controller for pending members based on id
	@GetMapping("/deltemp")
	public RedirectView deltemp(Integer id) {
		
		pendingRepo.deleteById(id);
		return new RedirectView("/temp");
	}
	
	@RequestMapping("/blog")
	public ModelAndView blog() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("blog");
		return mv;
	}
	///////////////////////////////////////////////////////////////////////////////////
	/////////////////////REST API FOR BOOK//////////////////////////////////////////

	
///////////// Post (/book) /////////////////////////////////////////////////////////////////	
	
	@PostMapping("/book")
	public ModelAndView addBookToDb( boockEntity boockEntity) {
		ModelAndView mv=new ModelAndView();
		bookRepo.save(boockEntity);
		mv.setViewName("book.html");
		return mv;
	}
	
//////////////////////GET(/books)///////////////////////////////////////////////////////////////	
	
	
	
	// /books {url for list of books}
	@GetMapping(path="/books",produces= {"application/json"})
	public List<boockEntity> getBooks() {
		
		return bookRepo.findAll();
	}
	
//////////////////////GET(/book/id)//////////////////////////////////////////////////////////////	
	
	

//  /books/id {is the url for search book by id}
	@GetMapping(path="/books/{id}",produces= {"application/json"})
	@ResponseBody
	public Optional<boockEntity> getBooksByID(@PathVariable("id") int id) {
		
		return bookRepo.findById(id);
	}
	
	
	////////DELETE (/books/id)/////////////////////////////////////////////////////////////////////////////////////////
	
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable int id) 
	{
	 boockEntity book=	bookRepo.getOne(id);
	 bookRepo.delete(book);
	 
	 return "deleted";
	}	
	
	/////////PUT (/books)///////////////////////////////////////////////////////////////////////////////////////////////////////////
     
	@PutMapping(path="/books",consumes={"application/json"})
	public boockEntity saveOrPudBook(@RequestBody boockEntity boockEntity) {
		
		bookRepo.save(boockEntity);
		return boockEntity;
	}
	
	
}

