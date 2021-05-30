package com.scg.auth.rest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

//import com.sp.service.UserService;
import com.scg.auth.service.AuthService;
//import com.sp.service.UserService;

@RestController
public class AuthRestCrt {
	//@Autowired
    //UserService uService;
	@Autowired
	AuthService aService;
    
    @RequestMapping("/login")
    public void page (@RequestParam(name="username", required=false, defaultValue="") String username,@RequestParam(name="password", required=false, defaultValue="") String password,HttpServletResponse response) {
    	    	
    	System.out.println(username);
    	System.out.println(password);
    	
    	String reqUrl = "http://127.0.0.1:8081/getUserId";
        RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object[]> id = restTemplate.getForEntity(reqUrl, Object[].class);
    	
		System.out.println(id);
		
  	  //int id = uService.checkUser(username, password);
  	  
  	 /* if (id!=0) {
  		  Cookie cookie = new Cookie("id", String.valueOf(id));

  		  //add cookie to response
  		  response.addCookie(cookie);
  		  try {
				response.sendRedirect("hub.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
  		  return ;
  		  }*/
		return;
    }
    
    @RequestMapping("/logout")
    public void logout(HttpServletResponse response) {
		  Cookie cookie = new Cookie("id", "0");
		  System.out.println("kiku");

		  response.addCookie(cookie);
		  try {
				response.sendRedirect("index.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		  return;
    }

    @RequestMapping(value="/signin")
    public void signin(@RequestParam(name="username", required=false, defaultValue="") String username,@RequestParam(name="password", required=false, defaultValue="") String password,HttpServletResponse response) {
        if (!username.equals("") && !password.equals("")) {
      	  uService.signIn(username, password);
  		  try {
				response.sendRedirect("index.html");
  		  } catch (IOException e) {
				e.printStackTrace();
  		  }
  		  return;
        }

		  return;
    }
    /*@RequestMapping("/consolecookie")
    public void consolecookie(HttpServletRequest req) {
  	  Optional<String> out=uService.readCookie(req, "id");
  	  System.out.println(out);
  	  return;
    }*/
    
   // @RequestMapping("/readCookie")
   // public String readCookie(@CookieValue(value = "id", defaultValue = "0") String id) {
  //	    return "Hey! My id is " + id;
  //	}
    
    
    @RequestMapping("/getCurrentUserId")
    public String readCookie(@CookieValue(value = "id", defaultValue = "0") String id) {
  	  return "The id of the current user is "+uService.readCookie(id);
    }
}
