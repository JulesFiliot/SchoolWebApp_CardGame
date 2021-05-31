package com.scg.market.rest;

import java.io.IOException;
import java.util.ArrayList;
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

import com.scg.market.service.MarketService;

@RestController
public class MarketRest {
	
	@Autowired
    MarketService mService;
    
    @RequestMapping(method=RequestMethod.GET,value="/buyCard/{cId}")
    public void buyCard (@PathVariable String cId) {
    	String reqUrl = "http://127.0.0.1:8083/getAuthId";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Integer> bodyIu = restTemplate.getForEntity(reqUrl, Integer.class);
        Integer uId = bodyIu.getBody();
    	mService.buyCard(uId.toString(),cId);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/sellCard/{cId}")
    public void sellCard (@PathVariable String cId) {
    	String reqUrl = "http://127.0.0.1:8083/getAuthId";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Integer> bodyIu = restTemplate.getForEntity(reqUrl, Integer.class);
        Integer uId = bodyIu.getBody();
		mService.sellCard(uId.toString(), cId);	
    }	
}
