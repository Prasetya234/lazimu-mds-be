package com.service.lazimu.web.repository;

import com.service.lazimu.web.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriRepository extends JpaRepository<Kategori, String> {
}
