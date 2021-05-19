package com.sp.service;

import java.util.Optional;
import java.util.Random;

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

	public boolean cardBought(String id, String cid) {
		Card c =getCard(Integer.parseInt(cid));
		if (c!=null) {
			c.setOwnerId(Integer.parseInt(id));
			cRepository.save(c);	
			return true;
		}
		return false;
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

	public boolean cardSold(String cid) {
		Card c =getCard(Integer.parseInt(cid));
		if(c!=null) {
			c.setOwnerId((Integer )0);
			cRepository.save(c);
			return true;
		}
		return false;
		
	}
	
	public void createAllCards() {
		Random rand = new Random();
		int nombreAleatoire = rand.nextInt(12);
		int i = 0;
		Card c;
		while (i < 50) {
			if (nombreAleatoire == 0) {c = new Card(0,"San Goku","KAMEHAMEHA!",80,null,0);}
			else if (nombreAleatoire == 1) {c = new Card(0,"Saitama","Série de coups sérieux",200,null,0);}
			else if (nombreAleatoire == 2) {c = new Card(0,"Ener","El Thor",110,null,0); }
			else if (nombreAleatoire == 3) {c = new Card(0,"Midorya","Texas Smash",90,null,0);}
			else if (nombreAleatoire == 4) {c = new Card(0,"Hero","Gigantaille",60,null,0);}
			else if (nombreAleatoire == 5) {c = new Card(0,"Magicarpe","Trempette",0,null,0);}
			else if (nombreAleatoire == 6) {c = new Card(0,"Griffith","Eclipse",400,null,0);}
			else if (nombreAleatoire == 7) {c = new Card(0,"Mirajane","Forme Démoniaque",80,null,0);}
			else if (nombreAleatoire == 8) {c = new Card(0,"Kagura","Neo Armstrong Cyclone Jet",250,null,0);}
			else if (nombreAleatoire == 9) {c = new Card(0, "Meriodasu", "Full counter", 60,null,0);}
			else {c = new Card(0, "Pain", "Shinra Tensei" , 110, null,0);}
	        addCard(c);
	        nombreAleatoire = rand.nextInt(12);
			i++;
		}
	}
}
