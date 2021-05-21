package com.scg.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import com.scg.model.Card;
import com.scg.repository.CardRepository;

import java.util.ArrayList;
import java.util.Iterator;


@Service
public class CardService {	
	
	private final CardRepository cRepository;
	
	public CardService(CardRepository cRepository) {
		this.cRepository = cRepository;
	}
	
	public void addCard(Card c) {
		Card createdCard=cRepository.save(c);
		System.out.println(createdCard);
	}
	
	public Card getCard(int id) {
		Optional<Card> cOpt =cRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		} else {
			return null;
		}
	}
	
	//Retourne le nom de l'utilisateur connecté grâce à l'id du cookie
	/*public String getUserName(@CookieValue(value = "id", defaultValue = "0") String id) {
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
	}*/

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
	
	//Retourne la liste des cartes d'un utilisateur
	public ArrayList<Card> getMarketCards() {
		ArrayList<Card> ListCard = new ArrayList<Card>();
		Iterable<Card> allCards =cRepository.findAll();
		Iterator<Card> iterator = allCards.iterator();
		while(iterator.hasNext()) {
		    Card it = iterator.next();
		    if (it.getOwnerId() == 0) {
		    	ListCard.add(it);
		    }
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
		int nombreAleatoire = rand.nextInt(13);
		int i = 0;
		Card c;
		while (i < 50) {
			if (nombreAleatoire == 0) {c = new Card(0,"San Goku","KAMEHAMEHA!","Dragon Ball",300,100,40,80,"./images/sangoku.webp",40,0);}
			else if (nombreAleatoire == 1) {c = new Card(0,"Saitama","Série de coups sérieux","One Punch Man",300,20,60,200,"./images/saitama.jpg",90,0);}
			else if (nombreAleatoire == 2) {c = new Card(0,"Ener","El Thor","One Piece",300,70,30,110,"./images/ener.png",70,0);}
			else if (nombreAleatoire == 3) {c = new Card(0,"Midorya","Texas Smash","My Hero Academia",200,70,10,90,"./images/midoriya.png",60,0);}
			else if (nombreAleatoire == 4) {c = new Card(0,"Hero","Gigantaille","Dragon Quest",100,100,10,60,"./images/hero.jpeg",30,0);}
			else if (nombreAleatoire == 5) {c = new Card(0,"Magicarpe","Trempette","Pokemon",10,1000,0,0,"./images/magicarpe.jpg",10,0);}
			else if (nombreAleatoire == 6) {c = new Card(0,"Griffith","Eclipse","Berserk",200,10,200,400,"./images/griffith.webp",120,0);}
			else if (nombreAleatoire == 7) {c = new Card(0,"Mirajane","Forme Démoniaque","Fairy Tail",200,80,50,80,"./images/mirajane.webp",50,0);}
			else if (nombreAleatoire == 8) {c = new Card(0,"Kagura","Neo Armstrong Cyclone Jet","Gintama",500,50,0,250,"./images/kagura.webp",100,0);}
			else if (nombreAleatoire == 9) {c = new Card(0, "Meliodas", "Full counter","Seven Deadly Sins",300,100,30,60,"./images/meliodas.jpg",50,0);}
			else if (nombreAleatoire == 10){c = new Card(0, "Pain","Shinra Tensei","Naruto",200,60,20,110, "./images/pain.png",70,0);}
			else {c = new Card(0,"Dio","Za Warudo","Jojo's Bizarre Adventure",500,100,100,100,"./images/dio.jpeg",500,0);} 
			addCard(c);
	        nombreAleatoire = rand.nextInt(12);
			i++;
		}
	}
}
