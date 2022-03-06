package com.antonqwerty.library.repository;

import com.antonqwerty.library.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
