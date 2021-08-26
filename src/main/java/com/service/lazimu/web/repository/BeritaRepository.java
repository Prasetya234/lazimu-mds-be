package com.service.lazimu.web.repository;

import com.service.lazimu.web.model.Berita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeritaRepository extends JpaRepository<Berita, String> {
}
