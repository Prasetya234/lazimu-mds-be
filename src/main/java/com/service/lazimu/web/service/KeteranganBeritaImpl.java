package com.service.lazimu.web.service;


import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.KeteranganBerita;
import com.service.lazimu.web.repository.BeritaRepository;
import com.service.lazimu.web.repository.KeteranganBeritaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class KeteranganBeritaImpl implements KeteranganBeritaService {

    @Autowired
    private KeteranganBeritaRepository keteranganBeritaRepository;

    @Autowired
    private BeritaRepository beritaRepository;

    @Override
    public List<KeteranganBerita> getAll() {
        return keteranganBeritaRepository.findAll();
    }

    @Override
    public KeteranganBerita create(KeteranganBerita keteranganBerita) throws ResourceNotFoundExceotion {
        return keteranganBeritaRepository.save(keteranganBerita);
    }

    @Override
    public KeteranganBerita update(String id, KeteranganBerita keteranganBerita) throws ResourceNotFoundExceotion {
        var update = keteranganBeritaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("ID NOT FOUND"));
        return keteranganBeritaRepository.save(update);
    }

    @Override
    public Map<String, Boolean> delete(String id) throws ResourceNotFoundExceotion {
        var delete = keteranganBeritaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("ID NOT FOUND"));
        keteranganBeritaRepository.deleteById(delete.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
