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

@Service
public class MarketService {

	public void buyCard(String cId) {
		String reqUrl = "http://127.0.0.1:8080/readUserCookie";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> bodyS = restTemplate.getForEntity(reqUrl, String.class);
		String uId = bodyS.getBody();
		
		reqUrl = "http://127.0.0.1:8080/getCurrentUserMoney/" + uId;
        ResponseEntity<Integer> bodyIu = restTemplate.getForEntity(reqUrl, Integer.class);
        Integer uMoney = bodyIu.getBody();
        
        reqUrl = "http://127.0.0.1:8081/priceCard/" + cId;
        ResponseEntity<Integer> bodyIc = restTemplate.getForEntity(reqUrl, Integer.class);
        Integer cPrice = bodyIc.getBody();
        
		if (uMoney >= cPrice) {
			System.out.println("youpi, je peux acheter");
			reqUrl = "http://127.0.0.1:8080/setCurrentUserMoney/" + cPrice.toString();
			restTemplate.getForEntity(reqUrl, Object[].class);
			
			reqUrl = "http://127.0.0.1:8081/setOwnerId/" + cId + "/" + uId;
			restTemplate.getForEntity(reqUrl, Object[].class);
			}
		System.out.println(uMoney);
		System.out.println(cPrice);
		System.out.println(uMoney >= cPrice);
		}

	public void sellCard(String cId) {
		String reqUrl = "http://127.0.0.1:8081/sellCard/" + cId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity(reqUrl, Object[].class);
        
        reqUrl = "http://127.0.0.1:8081/priceCard/" + cId;
        ResponseEntity<Integer> bodyI = restTemplate.getForEntity(reqUrl, Integer.class);
        Integer cPrice = -bodyI.getBody();
        
        reqUrl = "http://127.0.0.1:8080/setCurrentUserMoney/" + cPrice.toString();
		restTemplate.getForEntity(reqUrl, Object[].class);
	}
}
/*	
	public void testU(String str) {
		System.out.println(uService.namegetUser(str));
		
		
	}
	
*/

