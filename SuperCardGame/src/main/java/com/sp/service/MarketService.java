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
	CardService cService;


	public void buyCard(String id, String cid) {
		System.out.println("lesgo");
		uService.cardBought(id);
		cService.cardBought(id,cid);
	}

	public void sellCard(String id, String cid) {
		System.out.println("lesgo");
		uService.cardSold(id);
		cService.cardSold(cid);
	}
	
	public void testU(String str) {
		System.out.println(uService.namegetUser(str));
		
		
	}
	
}


