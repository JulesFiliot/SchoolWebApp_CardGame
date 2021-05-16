package com.sp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import com.sp.model.Card;
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
	
	public String namegetUser(String name) {
	//	List<User> uData =uRepository.findByName(name);
		if (uRepository.findByName(name)!=null) {
			return uRepository.findByName(name).getName();
			}
		return null;
		}
	
	public int checkUser(String username, String pwd) {
		int uid = 0;
		if (namegetUser(username)!=null) {
			if (pwd.equals(uRepository.findByName(username).getPassword())) {
				uid=uRepository.findByName(username).getId();
			}	
		}
		//System.out.println("Username et pwd dans checkUser:"+username+"&"+pwd);
		//if (username.equals("Paul") && pwd.equals("paul")) {uid = 1;}
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
     
 	public ArrayList<User> getAllUsers() {
		ArrayList<User> ListUser = new ArrayList<User>();
		Iterable<User> allUsers =uRepository.findAll();
		Iterator<User> iterator = allUsers.iterator();
		while(iterator.hasNext()) {
		    User it = iterator.next();
		    ListUser.add(it);
		}
		return ListUser;
	}
}
