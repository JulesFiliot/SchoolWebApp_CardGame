package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Hero;
import com.sp.repository.HeroRepository;

@Service
public class HeroService {
	@Autowired
	HeroRepository hRepository;
	public void addHero(Hero h) {
		Hero createdHero=hRepository.save(h);
		System.out.println(createdHero);
	}
	
	public Hero getHero(int id) {
		Optional<Hero> hOpt =hRepository.findById(id);
		if (hOpt.isPresent()) {
			return hOpt.get();
		}else {
			return null;
		}
	}

}
