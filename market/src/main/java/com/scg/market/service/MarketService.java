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

	public void buyCard(String uId, String cId) {
		System.out.println("ok dope life");
		String reqUrl = "http://127.0.0.1:8080/getCurrentUserMoney/" + uId;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Integer> bodyIu = restTemplate.getForEntity(reqUrl, Integer.class);
        Integer uMoney = bodyIu.getBody();
        
        reqUrl = "http://127.0.0.1:8081/priceCard/" + cId;
        ResponseEntity<Integer> bodyIc = restTemplate.getForEntity(reqUrl, Integer.class);
        Integer cPrice = bodyIc.getBody();

        
		if (uMoney >= cPrice) {				
			reqUrl = "http://127.0.0.1:8081/getOwnerId/" + cId;
			ResponseEntity<Integer> bodyIco = restTemplate.getForEntity(reqUrl, Integer.class);
			Integer currentOwnerId = bodyIco.getBody();
			
			if (currentOwnerId == 0) {
				Integer newUMoney = uMoney - cPrice;
				reqUrl = "http://127.0.0.1:8080/setCurrentUserMoney/" + uId + "/" + newUMoney.toString();
				restTemplate.getForEntity(reqUrl, Boolean.class);
				
				reqUrl = "http://127.0.0.1:8081/setOwnerId/" + cId + "/" + uId;
				restTemplate.getForEntity(reqUrl, Object[].class);
				}
			}
		}

	public void sellCard(String uId, String cId) {
		System.out.println("ok fast life");
		String reqUrl = "http://127.0.0.1:8081/getOwnerId/" + cId;
        RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Integer> bodyIco = restTemplate.getForEntity(reqUrl, Integer.class);
		Integer currentOwnerId = bodyIco.getBody();
		
		System.out.println(currentOwnerId == Integer.parseInt(uId));
		if (currentOwnerId == Integer.parseInt(uId)) {
			System.out.println("je suis dans le if");
			reqUrl = "http://127.0.0.1:8081/sellCard/" + cId;
	        restTemplate.getForEntity(reqUrl, Object[].class);
	        System.out.println("j'ai vendu la carte");
	        
	        reqUrl = "http://127.0.0.1:8080/getCurrentUserMoney/" + uId;
			ResponseEntity<Integer> bodyIu = restTemplate.getForEntity(reqUrl, Integer.class);
	        Integer uMoney = bodyIu.getBody();
	        System.out.println(uMoney);
	        
	        reqUrl = "http://127.0.0.1:8081/priceCard/" + cId;
	        ResponseEntity<Integer> bodyI = restTemplate.getForEntity(reqUrl, Integer.class);
	        Integer cPrice = bodyI.getBody();
	        System.out.println(cPrice);
	        
	        Integer newUMoney = uMoney + cPrice;
	        
	        reqUrl = "http://127.0.0.1:8080/setCurrentUserMoney/" + uId + "/" + newUMoney.toString();
			restTemplate.getForEntity(reqUrl, Boolean.class);
		}
	}
}
