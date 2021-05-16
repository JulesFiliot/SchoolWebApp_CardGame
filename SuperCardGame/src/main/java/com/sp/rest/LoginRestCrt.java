 package com.sp.rest;

  import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sp.service.UserService;

  @RestController
  public class LoginRestCrt {
      @Autowired
      UserService uService;
      
      
      @RequestMapping("/login")
      public ModelAndView page (@RequestParam(name="username", required=false, defaultValue="Jack") String username,@RequestParam(name="password", required=false, defaultValue="") String password,HttpServletResponse response) {
  		  System.out.println(username);
  		  System.out.println(password);
    	  int id = uService.checkUser(username, password);
    	  
    	  if (id!=0) {
    		  Cookie cookie = new Cookie("id", String.valueOf(id));

    		    //add cookie to response
    		  response.addCookie(cookie);
    		  ModelAndView modelAndView = new ModelAndView();
    		  modelAndView.setViewName("index");
    		  return modelAndView; 
    		  }
    	  
    	  else{
    		  ModelAndView modelAndView = new ModelAndView();
    		  modelAndView.setViewName("login");
    		  return modelAndView;
    		  }
      }
      

      @RequestMapping("/logout")
      public void logout(HttpServletResponse response) {
		  Cookie cookie = new Cookie("id", "0");
		  response.addCookie(cookie);
		  return;
      }
      
     /* 
      @RequestMapping(method=RequestMethod.POST,value="/login")
      public void login(@RequestBody )
    /*  @RequestMapping(value="/login")
      public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    	  model.addAttribute("name", name);
    	  return "greeting";
      
  /*    @RequestMapping(method=RequestMethod.POST,value="/hero")
      public void addHero(@RequestBody Hero hero) {
          hService.addHero(hero);
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/hero/{id}")
      public Hero getHero(@PathVariable String id) {
          Hero h=hService.getHero(Integer.valueOf(id));
          return h;
      }
*/
  }
