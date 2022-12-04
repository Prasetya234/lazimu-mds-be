package com.service.lazimu.web.repository;

import com.service.lazimu.web.model.Infaq;
import com.service.lazimu.web.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfaqRepository extends JpaRepository<Infaq, String> {
    List<Infaq> findAllByKategoriId(Kategori kategoriid);
}
