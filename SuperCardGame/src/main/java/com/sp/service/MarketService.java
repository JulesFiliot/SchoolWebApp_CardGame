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
		uService.namegetUser(id);
		cService.cardSold(id,cid);
	}

	public void testU(String str) {
		System.out.println(uService.namegetUser(str));
		
		
	}
	
}


