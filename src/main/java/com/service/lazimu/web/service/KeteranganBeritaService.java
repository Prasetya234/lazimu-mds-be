package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.KeteranganBerita;

import java.util.List;
import java.util.Map;

public interface KeteranganBeritaService {

    List<KeteranganBerita> getAll();

    KeteranganBerita create(KeteranganBerita keteranganBerita) throws ResourceNotFoundExceotion;

    KeteranganBerita update(String id, KeteranganBerita keteranganBerita) throws ResourceNotFoundExceotion;

    Map<String, Boolean> delete(String id) throws ResourceNotFoundExceotion;
}
