package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.Infaq;

import java.util.List;
import java.util.Map;

public interface InfaqService {
    List<Infaq> getAll(String category);

    Infaq create(Infaq infaq) throws ResourceNotFoundExceotion;

    Infaq update(String id, Infaq infaq) throws ResourceNotFoundExceotion;

    Map<String, Boolean> delete(String id) throws ResourceNotFoundExceotion;
}
