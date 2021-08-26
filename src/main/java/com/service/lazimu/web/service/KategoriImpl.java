package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.Kategori;
import com.service.lazimu.web.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KategoriImpl implements  KategoriService {
    @Autowired
    private KategoriRepository kategoriRepository;

    @Override
    public List<Kategori> getAll() {
        return kategoriRepository.findAll();
    }

    @Override
    public Kategori create(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    @Override
    public Kategori update(String id, Kategori kategori) throws ResourceNotFoundExceotion {
        var JSO98S = kategoriRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("KATEGORI ID NOT FOUND"));
        JSO98S.setKategoriName(kategori.getKategoriName());
        return kategoriRepository.save(JSO98S);
    }

    @Override
    public Map<String, Boolean> delete(String id) throws ResourceNotFoundExceotion {
        var JSO98S = kategoriRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("KATEGORI ID NOT FOUND"));
        kategoriRepository.deleteById(JSO98S.getKategoriId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
