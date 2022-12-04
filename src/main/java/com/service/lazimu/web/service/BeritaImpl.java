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
public class BeritaImpl implements BeritaService{

    private BeritaRepository beritaRepository;
    private KeteranganBeritaRepository keteranganBeritaRepository;
    private KategoriRepository kategoriRepository;

    @Autowired
    public BeritaImpl(BeritaRepository beritaRepository, KeteranganBeritaRepository keteranganBeritaRepository, KategoriRepository kategoriRepository) {
        this.beritaRepository = beritaRepository;
        this.keteranganBeritaRepository = keteranganBeritaRepository;
        this.kategoriRepository = kategoriRepository;
    }

    @Override
    public List<Berita> getAll() {
        return beritaRepository.findAll();
    }

    @Override
    public Berita getById(String id) throws ResourceNotFoundExceotion {
        Berita berita = beritaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("USER NOT FOUND"));
//        berita.setKeteranganBerita(keteranganBeritaRepository.findAllByBeritaOrderBySequenceNumberAsc(berita));
        return berita;
    }

    @Override
    public Berita create(Berita berita) throws ResourceNotFoundExceotion {
        var jj = kategoriRepository.findById(berita.getKategori()).orElseThrow(() -> new ResourceNotFoundExceotion("KATEGORI ID NOT FOUND"));
        berita.setKategoriId(jj);
        Berita data = beritaRepository.save(berita);
        List<KeteranganBerita> wadah = new ArrayList<>();
//        for (KeteranganBerita k : berita.getKeteranganBerita()) {
//            k.setBerita(data);
//            wadah.add(k);
//        }
        keteranganBeritaRepository.saveAll(wadah);

        return getById(data.getId());
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
