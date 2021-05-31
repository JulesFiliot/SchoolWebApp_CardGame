package com.scg.user.rest;



import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.scg.user.service.UserService;
import com.scg.user.model.User;

@RestController
public class UserRest {
    @Autowired
    UserService uService;
    

    //Return user's id given his password and username
    @RequestMapping(method = RequestMethod.POST, value="/getUserId")
    public int checkUser(@RequestBody User u) {
    	int ret = 0;
    	ret = uService.checkUser(u.getName(), u.getPassword());
    	return ret;
    }
    
    
    @RequestMapping(value="/getCurrentUserMoney")
    public int getUserMoney(@CookieValue(value = "id", defaultValue = "0") String id) {
    	User u = uService.getUser(Integer.parseInt(id));
    	if (u!=null) {
    		return u.getMoney();
    	}
    	else { return 0;}
    }
    
    @RequestMapping(value="/setCurrentUserMoney/{money}")
    public boolean setCurrentUserMoney(@CookieValue(value = "id", defaultValue = "0") String id, @PathVariable String money) {
    	User u = uService.getUser(Integer.parseInt(id));
    	if (u!=null) {
    		u.setMoney(Integer.parseInt(money));
    		return true;
    	}
    	else {
    		return false;}
    	}
     
    @RequestMapping(value="/testRP")
    public void testRP() {
    	System.out.println("ça fonctionne");
    }
   /* @RequestMapping(method=RequestMethod.POST,value="/user")
    public void addUser(@RequestBody User user) {
        uService.addUser(user);
        
        //String reqCard = "http://127.0.0.1:8081/generateCards/"+user.getId();
        //RestTemplate restTemplate = new RestTemplate();
		//restTemplate.getForEntity(reqCard, Object[].class);
		
		//Object[] objects = responseEntity.getBody();
		//MediaType contentType = responseEntity.getHeaders().getContentType();
		//HttpStatus statusCode = responseEntity.getStatusCode();

    }*/
    
    @RequestMapping(method=RequestMethod.GET,value="/user/{id}")
    public User getUser(@PathVariable String id) {
        User u=uService.getUser(Integer.valueOf(id));
        return u;
    }

    @RequestMapping(value="/createAllUsers")
    public void createAllUsers() {
  	  
        User u= new User(1,"Rex","dino",111);
        uService.addUser(u);
        u = new User(2,"Jack","gun",222);
        uService.addUser(u);

        return;
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/signin")
    public void signin(@RequestBody User u) {
  	  
        uService.signIn(u);
        return;
    }
    
    
    @RequestMapping(method=RequestMethod.GET,value="/username/{name}")
    public String namegetUser(@PathVariable String name) {
  	  String uname=uService.namegetUser(name);
  	  return uname;  
    }

    @RequestMapping(method=RequestMethod.GET,value="/allusers")
    public ArrayList<User> getAllUsers() {
    	ArrayList<User> users = uService.getAllUsers();
    	return users;
    }
    
 
    @RequestMapping(method=RequestMethod.GET,value="/readUserCookie")
    public String readUserCookie(@CookieValue(value = "id", defaultValue = "0") String id) {
    	return id;
    }
    
}

