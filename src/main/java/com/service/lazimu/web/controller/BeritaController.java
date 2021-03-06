package com.service.lazimu.web.controller;

import com.service.lazimu.enggine.response.CommonResponse;
import com.service.lazimu.enggine.response.CommonResponseGenerator;
import com.service.lazimu.web.dto.BeritaDTO;
import com.service.lazimu.web.model.Berita;
import com.service.lazimu.web.service.BeritaImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/berita")
public class BeritaController {
    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private BeritaImpl beritaService;

    @GetMapping
    public ResponseEntity<CommonResponse<Berita>> getAll() {
        try {
            return commonResponseGenerator.successResponse(beritaService.getAll());
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<BeritaDTO>> getById(@PathVariable("id") String id) {
        try {
            return commonResponseGenerator.successResponse(beritaService.getById(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<CommonResponse<Berita>> create(@RequestBody @Valid Berita berita) {
        try {
            return commonResponseGenerator.successResponse(beritaService.create(berita));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<Berita>> delete(@PathVariable("id") String id) {
        try {
            return commonResponseGenerator.successResponse(beritaService.delete(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
