package com.scg.user.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.scg.user.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByName(String name);
}
