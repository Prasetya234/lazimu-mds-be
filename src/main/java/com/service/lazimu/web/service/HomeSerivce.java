package com.service.lazimu.web.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HomeSerivce {
    public ResponseEntity<String> customHeader() {
        return ResponseEntity.ok().body(String.valueOf(new Date()) + "  Lazimu-BackEnd");
    }
}
