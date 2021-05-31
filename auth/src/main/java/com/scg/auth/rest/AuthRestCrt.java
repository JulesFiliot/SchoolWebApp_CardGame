package com.scg.auth.rest;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
import com.scg.auth.service.AuthService;
//import com.sp.service.UserService;


@RestController
public class AuthRestCrt {
	//@Autowired
    //UserService uService;
	@Autowired
	AuthService aService;
    
    @RequestMapping(method=RequestMethod.POST,value="/login")
    public void login (@RequestBody Map<String, String> repMap, HttpServletResponse response) {
    	String name = "";
		String password = "";

    	try {
    		name = (String) repMap.get("name");
    		password = (String) repMap.get("password");
    	} finally {}
    	// request body parameters
    	Map<String, String> map = new HashMap<>();
    	map.put("name", name);
    	map.put("password", password);
    	
    	String reqUrl = "http://127.0.0.1:8080/getUserId";
        RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Integer> reqId = restTemplate.postForEntity(reqUrl, map,Integer.class);

		Integer id = reqId.getBody();
  	  
  	  if (id != 0) {
  		  Cookie cookie = new Cookie("id", String.valueOf(id));

  		  //add cookie to response
  		  response.addCookie(cookie);
  		  try {
				response.sendRedirect("hub.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
  		  return;
  		  }
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
    public void signin(@RequestBody Map<String, String> repMap, HttpServletResponse response) {
        String username = "";
        String password = "";
        try {
        	username = (String) repMap.get("name");
    		password = (String) repMap.get("password");
    	} finally {}
    	
    	if (!username.equals("") && !password.equals("")) {
    		
    		// request body parameters
        	Map<String, String> map = new HashMap<>();
        	map.put("name", username);
        	map.put("password", password);
        	
        	//requesting signin
        	String reqUrl = "http://127.0.0.1:8080/signin";
            RestTemplate restTemplate = new RestTemplate();
    		restTemplate.postForEntity(reqUrl, map, Integer.class);

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
		return "The id of the current user is " + id;
    }
}
