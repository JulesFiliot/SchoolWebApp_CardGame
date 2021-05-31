package com.scg.auth.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.client.RestTemplate;

import com.scg.auth.model.Auth;
import com.scg.auth.repository.AuthRepository;

@Service
public class AuthService {
	
	@Autowired
	AuthRepository aRepository;
	
	public Integer getAuthId() {
		Iterable<Auth> Auth =aRepository.findAll();
		Iterator<Auth> iterator = Auth.iterator();
		Auth a = iterator.next();
		return a.getId();
	}

}
