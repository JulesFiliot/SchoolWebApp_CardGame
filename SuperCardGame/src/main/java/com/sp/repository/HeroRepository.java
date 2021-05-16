package com.sp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.sp.model.Hero;

public interface HeroRepository extends CrudRepository<Hero, Integer> {

	public List<Hero> findByName(String name);
}
