package com.service.lazimu.web.controller;

import com.service.lazimu.enggine.response.CommonResponse;
import com.service.lazimu.enggine.response.CommonResponseGenerator;
import com.service.lazimu.web.dto.UserDTO;
import com.service.lazimu.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse<Map<String, Boolean>>> delete(@RequestHeader("access") String access, @PathVariable("id") String id) {
        try {
            return commonResponseGenerator.successResponse(userService.delete(access,id));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
