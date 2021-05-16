package com.sp.service;

import java.util.Optional;

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
	
	public int checkUser(String username, String pwd) {
		int uid = 0;
		//username="Paul";
		//pwd="paul";
		System.out.println("Username et pwd dans checkUser:"+username+"&"+pwd);
		if (username.equals("Paul") && pwd.equals("paul")) {uid = 1;}
		System.out.println(uid);
		return uid;
		}

	public String getUserCookieId(@CookieValue(value = "id", defaultValue = "0") String userId) {
		return userId;
		
	}
	
}
