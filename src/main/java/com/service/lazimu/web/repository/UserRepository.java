package com.service.lazimu.web.repository;

import com.service.lazimu.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmailAddress(String emailAddress);

    User findByEmailAddressAndPasswordHash(String emailAddress, String passwordHash);
}
