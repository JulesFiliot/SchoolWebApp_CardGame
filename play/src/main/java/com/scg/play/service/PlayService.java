package com.scg.play.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scg.play.model.Play;
import com.scg.play.repository.PlayRepository;


@Service
public class PlayService {
	
	/*
	@Autowired
	public PlayRepository pRepository;
	*/
	
	private final PlayRepository pRepository;
	
	public PlayService(PlayRepository pRepository) {
		this.pRepository = pRepository;
	}
	
	
	public void newPlay() {
		Play p = new Play(0, "Roomain", 100);
		addPlay(p);
	}
	
	public void addPlay(Play p) {
		Play createdPlay = pRepository.save(p);
		System.out.println(createdPlay);
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
	
	public void addP1(int idP, int idU) {
		Play p = getPlay(idP);
		p.setIdP1(idU);
	}
	
}
