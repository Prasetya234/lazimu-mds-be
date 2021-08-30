package com.service.lazimu.web.controller;

import com.service.lazimu.enggine.response.CommonResponse;
import com.service.lazimu.enggine.response.CommonResponseGenerator;
import com.service.lazimu.web.dto.UserDTO;
import com.service.lazimu.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<CommonResponse<List<UserDTO>>> getAll(@RequestHeader("access") String access) {
        try {
         return  commonResponseGenerator.successResponse(userService.getAll(access));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
