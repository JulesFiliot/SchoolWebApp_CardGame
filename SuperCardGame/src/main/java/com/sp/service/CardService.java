package com.sp.service;

import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class CardService {
	@Autowired
	CardRepository cRepository;
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
	
	public ArrayList<Card> getMyCards(String id) {
		ArrayList<Card> ListCard = new ArrayList<Card>();
		int i=Integer.parseInt(id);
		Iterable<Card> allCards =cRepository.findAll();
		Iterator<Card> iterator = allCards.iterator();
		while(iterator.hasNext()) {
		    Card it = iterator.next();
		    if (it.getIdPos() == i) {
		    	ListCard.add(it);
		    }
		}
		return ListCard;
	}

}
