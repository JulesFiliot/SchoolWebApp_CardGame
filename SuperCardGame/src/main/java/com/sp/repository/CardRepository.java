package com.sp.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.sp.model.Card;
import java.util.Optional;

public interface CardRepository extends CrudRepository<Card, Integer> {

	public List<Card> findByName(String name);
	
}
