 package com.sp.rest;

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

import com.sp.service.MarketService;

  @RestController
  public class MarketRestCrt {
      @Autowired
      MarketService mService;
      
      
      @RequestMapping("/buy/{cid}")
      public void buyCard (@CookieValue(value = "id", defaultValue = "0") String id, @PathVariable String cid) {
  		  System.out.println("Je veux acheter la carte d'id "+cid);
  		  mService.buyCard(id, cid);	  
      }
      
      @RequestMapping("/testU/{str}")
      public void testU( @PathVariable String str) {
    	  
    	  mService.testU(str);
      }
 }
