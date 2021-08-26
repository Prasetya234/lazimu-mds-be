package com.service.lazimu.web.controller;

import com.service.lazimu.enggine.response.CommonResponse;
import com.service.lazimu.enggine.response.CommonResponseGenerator;
import com.service.lazimu.web.model.Kategori;
import com.service.lazimu.web.service.KategoriImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reference/kategori")
public class KategoriController {

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private KategoriImpl kategoriService;

    @GetMapping
    public CommonResponse<Kategori> getAll() {
        try {
            return commonResponseGenerator.successResponse(kategoriService.getAll());
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PostMapping
    public  CommonResponse<Kategori> create(@RequestBody Kategori kategori) {
        try {
            return commonResponseGenerator.successResponse(kategoriService.create(kategori));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public CommonResponse<Kategori> update(@PathVariable("id") String id, @RequestBody Kategori kategori) {
        try {
            return commonResponseGenerator.successResponse(kategoriService.update(id, kategori));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public CommonResponse<Kategori> delete(@PathVariable("id") String id) {
        try {
            return commonResponseGenerator.successResponse(kategoriService.delete(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
