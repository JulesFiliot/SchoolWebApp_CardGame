package com.scg.rest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.scg.model.Card;
import com.scg.service.CardService;

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
    
    @RequestMapping(method=RequestMethod.GET,value="/sellCard/{cId}")
    public void sellCard(@PathVariable String cId) {
        cService.cardSold(cId);
        return;
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/priceCard/{id}")
    public int getCardPrice(@PathVariable String id) {
        Card c=cService.getCard(Integer.valueOf(id));
        return c.getPrice();
    }
    //Affichage de liste des cartes
    /*@RequestMapping("/cardList")		
    public ModelAndView page (@CookieValue(value = "id", defaultValue = "0") String id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cardList");
        
        return modelAndView;
    }*/
    
    @RequestMapping(method=RequestMethod.GET, value="/mycards")
    public ArrayList<Card> getMyCards() {
    	String reqUrl = "http://127.0.0.1:8083/getAuthId";
    	RestTemplate resttemplate = new RestTemplate();
    	ResponseEntity<Integer> bodyId = resttemplate.getForEntity(reqUrl, Integer.class);
    	Integer id = bodyId.getBody();
    	
    	ArrayList<Card> cards = cService.getMyCards(id.toString());
    	return cards;
    }
    
    //GET la liste des cartes de l'utilisateur connecté
    @RequestMapping(method=RequestMethod.GET,value="/allcards")
    public ArrayList<Card> getAllCards() {
    	ArrayList<Card> cards = cService.getAllCards();
    	return cards;
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/marketCards")
    public ArrayList<Card> getMarketCards() {
    	ArrayList<Card> cards = cService.getMarketCards();
    	return cards;
    }
    
    @RequestMapping(value="/createAllCards")
    public void createAllCards() {
    	cService.createAllCards();
        return;
    }
    
    @RequestMapping(value="/generateCards/{id}")
    public void generateCards(@PathVariable String id) {
    	cService.generateCards(id);
    	return;
    }
    
    @RequestMapping(value="/setOwnerId/{cId}/{uId}")
    public void setOwnerId(@PathVariable String cId, @PathVariable String uId) {
    	cService.setOwnerId(cId,uId);
    	return;
    }
    
    @RequestMapping(value="/getOwnerId/{cId}")
    public Integer getOwnerId(@PathVariable String cId) {
    	return cService.getOwnerId(cId);
    }
    
    @RequestMapping(value="/cardSold/{cId}")
    public void soldCard(@PathVariable String cId) {
    	cService.cardSold(cId);
    	return;
    }
    
    @RequestMapping("/login")
    public void page () {
  		  Cookie cookie = new Cookie("id", String.valueOf(2));
    }
}
