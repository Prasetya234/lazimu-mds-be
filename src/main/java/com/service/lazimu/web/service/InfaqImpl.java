package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.Infaq;
import com.service.lazimu.web.model.Kategori;
import com.service.lazimu.web.repository.InfaqRepository;
import com.service.lazimu.web.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InfaqImpl implements InfaqService{
    @Autowired
    private InfaqRepository infaqRepository;

    @Autowired
    private KategoriRepository kategoriRepository;

    @Override
    public List<Infaq> getAll(String category) {
        if (category != null) {
            if (category.equals("sosial")) {
                return infaqRepository.findAllByKategoriId(kategoriRepository.findById("8775cfa8-bbc0-47c0-a1b6-4056f1847094").get());
            }
            if (category.equals("ekonomi")) {
                return infaqRepository.findAllByKategoriId(kategoriRepository.findById("3c47c324-75af-41a9-8587-7c1a5f92d4fc").get());
            }
            if (category.equals("pendidikan")) {
                return infaqRepository.findAllByKategoriId(kategoriRepository.findById("0f928276-73a1-4b92-adc8-3cbecf4cd1b0").get());
            }
        }
        return infaqRepository.findAll();
    }

    @Override
    public Infaq create(Infaq infaq) throws ResourceNotFoundExceotion {
        var kategori = kategoriRepository.findById(infaq.getKategori()).orElseThrow(() -> new ResourceNotFoundExceotion("KATEGORI ID NOT FOUND"));
        infaq.setKategoriId(kategori);
        return infaqRepository.save(infaq);
    }

    @Override
    public Infaq update(String id, Infaq infaq) throws ResourceNotFoundExceotion {
        var update = infaqRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("INFAQ ID NOT FOUND"));
        update.setJudul(infaq.getJudul());
        update.setImage(infaq.getImage());
        update.setDonasi(infaq.getDonasi());
        update.setDonatur(infaq.getDonatur());
        update.setKategori(infaq.getKategori());
        var kategori = kategoriRepository.findById(update.getKategori()).orElseThrow(() -> new ResourceNotFoundExceotion("KATEGORI ID NOT FOUND"));
        update.setKategoriId(kategori);
        return infaqRepository.save(update);
    }

    @Override
    public Map<String, Boolean> delete(String id) throws ResourceNotFoundExceotion {
        var delete = infaqRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("INFAQ ID NOT FOUND"));
        infaqRepository.deleteById(delete.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
