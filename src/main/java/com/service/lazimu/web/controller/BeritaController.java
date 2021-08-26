package com.service.lazimu.web.controller;

import com.service.lazimu.enggine.response.CommonResponse;
import com.service.lazimu.enggine.response.CommonResponseGenerator;
import com.service.lazimu.web.dto.BeritaDTO;
import com.service.lazimu.web.model.Berita;
import com.service.lazimu.web.service.BeritaImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/berita")
public class BeritaController {
    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private ModelMapper modalMapper;

    @Autowired
    private BeritaImpl beritaService;

    @GetMapping
    public CommonResponse<Berita> getAll() {
        try {
            return commonResponseGenerator.successResponse(beritaService.getAll());
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public CommonResponse<BeritaDTO> getById(@PathVariable("id") String id) {
        try {
            return commonResponseGenerator.successResponse(beritaService.getById(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PostMapping("/")
    public CommonResponse<BeritaDTO> create(@RequestBody @Valid BeritaDTO berita) {
        try {
            var LKLsakslslS= modalMapper.map(berita, Berita.class);
            return commonResponseGenerator.successResponse(beritaService.create(LKLsakslslS));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PutMapping("/{uuid}")
    public CommonResponse<Berita> update(@PathVariable("uuid") String uuid, @RequestBody BeritaDTO berita) {
        try {
            var SDOKF29 = modalMapper.map(berita, Berita.class);
            return commonResponseGenerator.successResponse(beritaService.update(uuid, SDOKF29));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{uuid}")
    public CommonResponse<Berita> delete(@PathVariable("uuid") String uuid) {
        try {
            return commonResponseGenerator.successResponse(beritaService.delete(uuid));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
