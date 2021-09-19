package com.service.lazimu.web.repository;

import com.service.lazimu.web.model.Infaq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfaqRepository extends JpaRepository<Infaq, String> {
}
