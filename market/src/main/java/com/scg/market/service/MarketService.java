package com.scg.market.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.service.CardService;
import com.sp.service.UserService;

/*
import com.scg.user.service.UserService;
import com.scg.model.Card;
import com.scg.service.CardService;

import com.scg.card.model.User;
*/

public class MarketService {
/*
	@Autowired
	UserService uService;
	@Autowired
	CardService cService;


	public void buyCard(String id, String cid) {
		User u = uService.getUser(Integer.parseInt(id));
		Card c = cService.getCard(Integer.parseInt(cid));
		if (c!=null) {
			int p = c.getPrice();
			int a = u.getMoney();
			if (a >= p) {
				if(cService.cardBought(id,cid)) {
					uService.cardBought(id, p);
				}
			}
		}
	}

	public void sellCard(String id, String cid) {
		if(cService.cardSold(cid)) {
			Card c = cService.getCard(Integer.parseInt(cid));
			int p = c.getPrice();
			uService.cardSold(id,p);
		}

	}
	
	public void testU(String str) {
		System.out.println(uService.namegetUser(str));
		
		
	}
	
*/
}
