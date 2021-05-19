
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
    /*@RequestMapping("/cardList")		
    public ModelAndView page (@CookieValue(value = "id", defaultValue = "0") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cardList");
        
        return modelAndView;
    }*/
    
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
    	cService.createAllCards();
        return;
    }
}
