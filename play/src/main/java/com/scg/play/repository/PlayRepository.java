package com.scg.play.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.scg.play.model.Play;

public interface PlayRepository extends CrudRepository<Play, Integer> {

	public List<Play> findByName(String name);
	
}
