package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

import java.util.ArrayList;
import java.util.Iterator;

import com.sp.service.UserService;

@Service
public class CardService {	
	
	private final CardRepository cRepository;
	private final UserService uService;
	
	public CardService(CardRepository cRepository, UserService uService) {
		this.cRepository = cRepository;
		this.uService = uService;
	}
	
	
	public void addCard(Card c) {
		Card createdCard=cRepository.save(c);
		System.out.println(createdCard);
	}
	
	public Card getCard(int id) {
		Optional<Card> cOpt =cRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}
	
	//Retourne le nom de l'utilisateur connecté grâce à l'id du cookie
	public String getUserName(@CookieValue(value = "id", defaultValue = "0") String id) {
		String ret;
		String name;
		int integerId;
		
		integerId = Integer.parseInt(id);
		name = uService.getUser(integerId).getName();
		System.out.println(name);
		if (name == null) {
			ret = "none";
		}
		else {
			ret = name;
		}
		
		return ret;
	}

	public void cardBought(String id, String cid) {
		getCard(Integer.parseInt(cid)).setOwnerId(Integer.parseInt(cid));
	}
	
	//Retourne la liste des cartes d'un utilisateur
	public ArrayList<Card> getMyCards(String id) {
		ArrayList<Card> ListCard = new ArrayList<Card>();
		int i=Integer.parseInt(id);
		Iterable<Card> allCards =cRepository.findAll();
		Iterator<Card> iterator = allCards.iterator();
		while(iterator.hasNext()) {
		    Card it = iterator.next();
		    if (it.getOwnerId() == i) {
		    	ListCard.add(it);
		    }
		}
		return ListCard;
	}
	
	public ArrayList<Card> getAllCards() {
		ArrayList<Card> ListCard = new ArrayList<Card>();
		Iterable<Card> allCards =cRepository.findAll();
		Iterator<Card> iterator = allCards.iterator();
		while(iterator.hasNext()) {
		    Card it = iterator.next();
		    ListCard.add(it);
		}
		return ListCard;
	}

	public void cardSold(String cid) {
		getCard(Integer.parseInt(cid)).setOwnerId(0);		
	}
}
