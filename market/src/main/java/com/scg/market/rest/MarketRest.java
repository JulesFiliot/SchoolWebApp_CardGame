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
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.scg.market.service.MarketService;

@RestController
public class MarketRest {
	
	@Autowired
    MarketService mService;
    
    @RequestMapping(method=RequestMethod.GET,value="/buyCard/{cId}")
    public void buyCard (@CookieValue (value = "id", defaultValue = "0") String uId, @PathVariable String cId) {
		  mService.buyCard(uId,cId);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/sellCard/{cId}")
    public void sellCard (@CookieValue(value = "id", defaultValue = "0") String uId, @PathVariable String cId) {
		  mService.sellCard(uId, cId);	
    }	
}
