package com.scg.play.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.scg.play.model.Play;
import com.scg.play.repository.PlayRepository;


public class PlayService {

	@Autowired
	PlayRepository pRepository;
	
	
	public void newPlay() {
		Play p = new Play("Roomain", 100);
		pRepository.save(p);
	}
	
	public void addPlay(Play p) {
		Play createdPlay = pRepository.save(p);
		System.out.println(createdPlay);
		/*
        String reqCard = "http://127.0.0.1:8081/generateCards/"+u.getId();
        RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForEntity(reqCard, Object[].class);
		*/	
	}
	
	public Play getPlay(int id) {
		Optional<Play> pOpt =pRepository.findById(id);
		if (pOpt.isPresent()) {
			return pOpt.get();
		}else {
			return null;
		}
	}
	
	public ArrayList<Play> getAllPlay() {
		ArrayList<Play> ListPlay = new ArrayList<Play>();
		Iterable<Play> allPlay =pRepository.findAll();
		Iterator<Play> iterator = allPlay.iterator();
		while(iterator.hasNext()) {
		    Play it = iterator.next();
		    ListPlay.add(it);
		}
		return ListPlay;
 	}
	
}
