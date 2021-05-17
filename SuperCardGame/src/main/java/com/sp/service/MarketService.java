package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sp.service.UserService;
import com.sp.service.CardService;

@Service
public class MarketService {
	@Autowired
	UserService uService;
	@Autowired
	CardService cService;


	public void buyCard(String id, String cid) {
		System.out.println("lesgo");

		if(cService.cardBought(id,cid)) {
			uService.cardBought(id);
		}
	}

	public void sellCard(String id, String cid) {
		System.out.println("lesgo");
		if(cService.cardSold(cid)) {
			uService.cardSold(id);
		}

	}
	
	public void testU(String str) {
		System.out.println(uService.namegetUser(str));
		
		
	}
	
}


