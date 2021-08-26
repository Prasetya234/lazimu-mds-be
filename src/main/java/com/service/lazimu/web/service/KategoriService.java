package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.Kategori;

import java.util.List;
import java.util.Map;

public interface KategoriService {

    List<Kategori> getAll();

    Kategori create(Kategori kategori);

    Kategori update(String id, Kategori kategori) throws ResourceNotFoundExceotion;

    Map<String, Boolean> delete(String id) throws ResourceNotFoundExceotion;
}
