package com.scg.play.rest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scg.play.model.Play;
import com.scg.play.service.PlayService;

@RestController
public class PlayRest {

	@Autowired
	PlayService pService;
	
	
	@RequestMapping(value="/newPlay")
    public void newPlay() {
        pService.newPlay();
        return;
    }
	
    @RequestMapping(method=RequestMethod.POST,value="/addPlay")
    public void addPlay(@RequestBody Play p) {
        pService.addPlay(p);
        return;
    }
	
    @RequestMapping(method=RequestMethod.GET,value="/play/{id}")
    public Play getPlay(@PathVariable String id) {
        Play p = pService.getPlay(Integer.valueOf(id));
        return p;
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/allPlay")
    public ArrayList<Play> getAllPlay() {
    	ArrayList<Play> play = pService.getAllPlay();
    	return play;
    }
    
    @RequestMapping(value="/createPlay")
    public void createPlay(@RequestParam(name="name", required=false, defaultValue="") String name,@RequestParam(name="pari", required=false, defaultValue="") String pari,HttpServletResponse response) {
        int i; 
    	if (!name.equals("") && !pari.equals("")) {
    		i = Integer.parseInt(pari);
          Play p = new Play(0, name, i);
      	  pService.addPlay(p);
  		  try {
				response.sendRedirect("http://127.0.0.1:8090/waitingRoom.html");
  		  } catch (IOException e) {
				// TODO Auto-generated catch block
  			  	System.out.println("pas fonctionné");
				e.printStackTrace();
  		  }
  		  return;
        }

		  return;
    }
    
    @RequestMapping(value="/addP1/{id}")
    public void addP1(@PathVariable String idP, @CookieValue (value = "id", defaultValue = "0") String idU) {
    	int ip = Integer.parseInt(idP);
    	int iu = Integer.parseInt(idU);
    	pService.addP1(ip,iu);
    	return;
    }
    
}
