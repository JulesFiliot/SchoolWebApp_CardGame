 package com.sp.rest;

  import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

  import com.sp.model.User;
  import com.sp.service.UserService;

  @RestController
  public class UserRestCrt {
      @Autowired
      UserService uService;
      
      @RequestMapping(method=RequestMethod.POST,value="/user")
      public void addUser(@RequestBody User user) {
          uService.addUser(user);
      }
      
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
      
      @RequestMapping(method=RequestMethod.GET,value="/username/{name}")
      public String namegetUser(@PathVariable String name) {
    	  String uname=uService.namegetUser(name);
    	  return uname;
    	  
      }

  }