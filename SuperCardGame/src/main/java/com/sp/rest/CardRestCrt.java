
package com.sp.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.service.CardService;

@RestController
public class CardRestCrt {
    @Autowired
    CardService cService;
    
    @RequestMapping(method=RequestMethod.POST,value="/card")
    public void addCard(@RequestBody Card card) {
        cService.addCard(card);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/card/{id}")
    public Card getCard(@PathVariable String id) {
        Card c=cService.getCard(Integer.valueOf(id));
        return c;
    }
    
    //Affichage de liste des cartes
    @RequestMapping("/cardList")		
    public ModelAndView page (@CookieValue(value = "id", defaultValue = "0") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cardList");
        
        String userName = cService.getUserName(id);
        ArrayList<Card> userCards;
        modelAndView.addObject("userName", userName);
        userCards = cService.getMyCards(id);
        modelAndView.addObject("userCards", userCards);
        
        return modelAndView;
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/mycards")
    public ArrayList<Card> getMyCards(@CookieValue(value = "id", defaultValue = "0") String id) {
    	ArrayList<Card> cards = cService.getMyCards(id);
    	return cards;
    }
    
    //GET la liste des cartes de l'utilisateur connecté
    @RequestMapping(method=RequestMethod.GET,value="/allcards")
    public ArrayList<Card> getAllCards() {
    	ArrayList<Card> cards = cService.getAllCards();
    	return cards;
    }
    
    @RequestMapping(value="/createAllCards")
    public void createAllCards() {
  	  
        Card c= new Card(1,"San Goku","KAMEHAMEHA!",80,null,0);
        cService.addCard(c);
        c = new Card(2,"Saitama","Série de coups sérieux",200,null,0);
        cService.addCard(c);
        c = new Card(3,"Ener","El Thor",110,null,0);
        cService.addCard(c);
        c = new Card(4,"Midorya","Texas Smash",90,null,0);
        cService.addCard(c);
        c = new Card(5,"Hero","Gigantaille",60,null,0);
        cService.addCard(c);
        c = new Card(6,"Magicarpe","Trempette",0,null,0);
        cService.addCard(c);
        c = new Card(7,"Griffith","Eclipse",400,null,0);
        cService.addCard(c);
        c = new Card(8,"Mirajane","Forme Démoniaque",80,null,0);
        cService.addCard(c);
        c = new Card(9,"Kagura","Neo Armstrong Cyclone Jet",250,null,0);
        cService.addCard(c);
        c = new Card(10, "Meriodasu", "Full counter", 60,null,0);
        cService.addCard(c);
        c = new Card(11, "Pain", "Shinra Tensei" , 110, null,0);
        cService.addCard(c);

        return;
    }
}
