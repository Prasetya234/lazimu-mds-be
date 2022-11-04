package com.service.lazimu.web.repository;

import com.service.lazimu.web.model.Berita;
import com.service.lazimu.web.model.KeteranganBerita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeteranganBeritaRepository extends JpaRepository<KeteranganBerita, String> {
    List<KeteranganBerita> findAllByBeritaOrderBySequenceNumberAsc(Berita berita);
}
