package com.service.lazimu.web.controller;

import com.service.lazimu.enggine.response.CommonResponse;
import com.service.lazimu.enggine.response.CommonResponseGenerator;
import com.service.lazimu.web.dto.InfaqDTO;
import com.service.lazimu.web.model.Infaq;
import com.service.lazimu.web.service.InfaqService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/infaq")
public class InfaqController {

    @Autowired
    private InfaqService infaqService;

    @Autowired
    private ModelMapper modalMapper;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @GetMapping
    public ResponseEntity<CommonResponse<Infaq>> getAll() {
        return commonResponseGenerator.successResponse(infaqService.getAll());
    }

    @PostMapping
    public ResponseEntity<CommonResponse<InfaqDTO>> create(@RequestBody InfaqDTO infaq) {
        try {
            var mapeer = modalMapper.map(infaq, Infaq.class);
            return commonResponseGenerator.successResponse(infaqService.create(mapeer));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse<InfaqDTO>> create(@PathVariable("id") String id, @RequestBody InfaqDTO infaq) {
        try {
            var mapeer = modalMapper.map(infaq, Infaq.class);
            return commonResponseGenerator.successResponse(infaqService.update(id, mapeer));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<InfaqDTO>> delete(@PathVariable("id") String id) {
        try {
            return commonResponseGenerator.successResponse(infaqService.delete(id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
