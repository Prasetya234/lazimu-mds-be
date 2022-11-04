package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.Berita;
import com.service.lazimu.web.model.KeteranganBerita;
import com.service.lazimu.web.repository.BeritaRepository;
import com.service.lazimu.web.repository.KategoriRepository;
import com.service.lazimu.web.repository.KeteranganBeritaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BeritaImpl implements BeritaService{

    @Autowired
    private BeritaRepository beritaRepository;

    @Autowired
    private KeteranganBeritaRepository keteranganBeritaRepository;

    @Autowired
    private KategoriRepository kategoriRepository;

    @Override
    public List<Berita> getAll() {
        List<Berita> list = beritaRepository.findAll();
        List<Berita> res = new ArrayList<>();
        for (Berita b: list) {
            b.setKeteranganBerita(keteranganBeritaRepository.findAllByBeritaOrderBySequenceNumberAsc(b));
            res.add(b);
        }
        return res;
    }

    @Override
    public Berita getById(String id) throws ResourceNotFoundExceotion {
        Berita berita = beritaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("USER NOT FOUND"));
        berita.setKeteranganBerita(keteranganBeritaRepository.findAllByBeritaOrderBySequenceNumberAsc(berita));
        return berita;
    }

    @Override
    public Berita create(Berita berita) throws ResourceNotFoundExceotion {
        var jj = kategoriRepository.findById(berita.getKategori()).orElseThrow(() -> new ResourceNotFoundExceotion("KATEGORI ID NOT FOUND"));
        berita.setKategoriId(jj);
        return beritaRepository.save(berita);
    }

    @Override
    public Map<String, Boolean> delete(String id) throws ResourceNotFoundExceotion {
        var MOSO23 = beritaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("USER NOT FOUND"));
        beritaRepository.deleteById(MOSO23.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
