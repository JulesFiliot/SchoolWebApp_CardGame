package com.scg.market.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
import com.scg.user.service.UserService;
import com.scg.model.Card;
import com.scg.service.CardService;

import com.scg.card.model.User;
*/

public class MarketService {

	public void buyCard(String cId) {
		String reqUrl = "http://127.0.0.1:8080/getCurrentUserMoney";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> bodyI = restTemplate.getForEntity(reqUrl, Integer.class);
        Integer uMoney = bodyI.getBody();
        
        reqUrl = "http://127.0.0.1:8081/priceCard/" + cId;
        bodyI = restTemplate.getForEntity(reqUrl, Integer.class);
        Integer cPrice = bodyI.getBody();
        
		if (uMoney >= cPrice) {
			reqUrl = "http://127.0.0.1:8080/setCurrentUserMoney/" + cPrice.toString();
			restTemplate.getForEntity(reqUrl, Object[].class);
			
			reqUrl = "http://127.0.0.1:8080/readUserCookie";
			ResponseEntity<String> bodyS = restTemplate.getForEntity(reqUrl, String.class);
			String uId = bodyS.getBody();
			
			reqUrl = "http://127.0.0.1:8081/setOwnerId/" + cId + "/" + uId;
			restTemplate.getForEntity(reqUrl, Object[].class);
			}
		}

	public void sellCard(String cId) {
		String reqUrl = "http://127.0.0.1:8081/cardSold/" + cId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity(reqUrl, Object[].class);
        
        reqUrl = "http://127.0.0.1:8081/priceCard/" + cId;
        ResponseEntity<Integer> bodyI = restTemplate.getForEntity(reqUrl, Integer.class);
        Integer cPrice = -bodyI.getBody();
        
        reqUrl = "http://127.0.0.1:8080/setCurrentUserMoney/" + cPrice.toString();
		restTemplate.getForEntity(reqUrl, Object[].class);
		}


/*	
	public void testU(String str) {
		System.out.println(uService.namegetUser(str));
		
		
	}
	
*/
}