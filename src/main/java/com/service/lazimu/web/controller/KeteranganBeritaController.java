package com.service.lazimu.web.controller;

import com.service.lazimu.enggine.response.CommonResponse;
import com.service.lazimu.enggine.response.CommonResponseGenerator;
import com.service.lazimu.web.model.KeteranganBerita;
import com.service.lazimu.web.service.KeteranganBeritaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/berita/keterangan-berita")
public class KeteranganBeritaController {

    @Autowired
    private KeteranganBeritaService keteranganBeritaService;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;


    @GetMapping
    public ResponseEntity<CommonResponse<KeteranganBerita>> getAll(){
            return commonResponseGenerator.successResponse(keteranganBeritaService.getAll());
    }

    @PostMapping
    public ResponseEntity<CommonResponse<KeteranganBerita>> create(@RequestBody KeteranganBerita keteranganBerita) {
        try {
            return commonResponseGenerator.successResponse(keteranganBeritaService.create(keteranganBerita));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse<KeteranganBerita>> update(@PathVariable("id") String id, @RequestBody KeteranganBerita keteranganBerita){
        try {
            return commonResponseGenerator.successResponse(keteranganBeritaService.update(id, keteranganBerita));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<KeteranganBerita>> delete(@PathVariable("id") String id){
        try {
            return commonResponseGenerator.successResponse(keteranganBeritaService.delete(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
