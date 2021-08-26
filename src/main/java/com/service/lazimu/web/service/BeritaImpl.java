package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.Berita;
import com.service.lazimu.web.repository.BeritaRepository;
import com.service.lazimu.web.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BeritaImpl implements BeritaService{

    @Autowired
    private BeritaRepository beritaRepository;

    @Autowired
    private KategoriRepository kategoriRepository;

    @Override
    public List<Berita> getAll() {
        return beritaRepository.findAll();
    }

    @Override
    public Berita getById(String id) throws ResourceNotFoundExceotion {
        return beritaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("USER NOT FOUND"));
    }

    @Override
    public Berita create(Berita berita) throws ResourceNotFoundExceotion {
        var jj = kategoriRepository.findById(berita.getKategori()).orElseThrow(() -> new ResourceNotFoundExceotion("KATEGORI ID NOT FOUND"));
        berita.setKategoriId(jj);
        return beritaRepository.save(berita);
    }

    @Override
    public Berita update(String id, Berita berita) throws ResourceNotFoundExceotion {
        var SAK28 = beritaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("USER NOT FOUND"));
        SAK28.setJudul(berita.getJudul());
        SAK28.setCreatedDate(berita.getCreatedDate());
        SAK28.setAuthor(berita.getAuthor());
        SAK28.setKeterangan(berita.getKeterangan());
        SAK28.setImage(berita.getImage());
        return beritaRepository.save(SAK28);
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
