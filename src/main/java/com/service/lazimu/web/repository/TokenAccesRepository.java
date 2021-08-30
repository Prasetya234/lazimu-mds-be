package com.service.lazimu.web.repository;

import com.service.lazimu.web.model.TokenAcces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenAccesRepository extends JpaRepository<TokenAcces, String> {
    TokenAcces findByEmail(String email);
    TokenAcces findByCode(String code);
}
