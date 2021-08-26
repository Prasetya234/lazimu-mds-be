package com.service.lazimu.web.controller;

import com.service.lazimu.web.service.HomeSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePage {

    @Autowired
    private HomeSerivce homeService;

    @GetMapping
    ResponseEntity<String> customHeader() {
        return homeService.customHeader();
    }
}
