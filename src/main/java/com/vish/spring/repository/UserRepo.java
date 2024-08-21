package com.vish.spring.repository;

import com.vish.spring.entity.UserData;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserData, String> {
  Optional<UserData> findByEmail(String email);
}
