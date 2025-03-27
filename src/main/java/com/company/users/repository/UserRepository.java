package com.company.users.repository;

import com.company.users.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUuid(String uuid);
  Optional<User> findByEmail(String email);
}
