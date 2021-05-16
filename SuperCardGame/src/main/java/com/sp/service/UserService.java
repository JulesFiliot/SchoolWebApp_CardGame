package com.sp.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import com.sp.model.User;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository uRepository;
	public void addUser(User u) {
		User createdUser=uRepository.save(u);
		System.out.println(createdUser);
	}
	
	public User getUser(int id) {
		Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}
	
	public List<User> namegetUser(String name) {
		List<User> uOpt =uRepository.findByName(name);
		return uOpt;
	}
	
	public int checkUser(String username, String pwd) {
		int uid = 0;
		
		System.out.println("Username et pwd dans checkUser:"+username+"&"+pwd);
		if (username.equals("Paul") && pwd.equals("paul")) {uid = 1;}
		System.out.println(uid);
		return uid;
		}

   /* public Optional<String> readCookie(HttpServletRequest request,String key) {
	    return Arrays.stream(request.getCookies())
	      .filter(c -> key.equals(c.getName()))
	      .map(Cookie::getValue)
	      .findAny();
	}*/
    
     public String readCookie(@CookieValue(value = "id", defaultValue = "0") String id) {
   	    return id;
     }
}
