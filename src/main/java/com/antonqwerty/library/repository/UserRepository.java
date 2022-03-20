package com.antonqwerty.library.repository;

import com.antonqwerty.library.model.SecurityUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<SecurityUser, Long> {
    SecurityUser findByName(String username);
}
