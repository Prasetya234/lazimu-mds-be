package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.Berita;

import java.util.List;
import java.util.Map;

public interface BeritaService {
    List<Berita> getAll();

    Berita getById(String id) throws ResourceNotFoundExceotion;

    Berita create(Berita Berita) throws ResourceNotFoundExceotion;

    Berita update(String id, Berita berita) throws ResourceNotFoundExceotion;

    Map<String,Boolean> delete(String id) throws ResourceNotFoundExceotion;
}
