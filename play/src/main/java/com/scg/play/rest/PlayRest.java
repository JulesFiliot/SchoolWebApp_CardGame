package com.scg.play.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scg.play.model.Play;
import com.scg.play.service.PlayService;

public class PlayRest {

	@Autowired
	PlayService pService;
	
	
    @RequestMapping(method=RequestMethod.POST,value="/addPlay")
    public void addPlay(@RequestBody Play p) {
        pService.addPlay(p);
        return;
    }
	
}
