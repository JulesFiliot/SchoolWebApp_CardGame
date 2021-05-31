package com.scg.auth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.scg.auth.model.Auth;



public interface AuthRepository extends CrudRepository<Auth,Integer>{

		public List<Auth> findByName(String name);
		
}

