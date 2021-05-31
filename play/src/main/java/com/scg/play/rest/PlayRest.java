package com.scg.play.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scg.play.model.Play;
import com.scg.play.service.PlayService;

public class PlayRest {

	@Autowired
	PlayService pService;
	
	
	@RequestMapping(method=RequestMethod.POST,value="/newPlay")
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
    
}
