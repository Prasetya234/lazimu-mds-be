package com.service.lazimu.web.controller;

import com.service.lazimu.enggine.response.CommonResponse;
import com.service.lazimu.enggine.response.CommonResponseGenerator;
import com.service.lazimu.web.dto.UserDTO;
import com.service.lazimu.web.model.ChangePassword;
import com.service.lazimu.web.model.TokenAcces;
import com.service.lazimu.web.model.User;
import com.service.lazimu.web.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class Authentication {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse<UserDTO>> register(@RequestBody @Valid UserDTO userDTO) {
        try {
            User user = modelMapper.map(userDTO, User.class);
            return commonResponseGenerator.successResponse(userService.register(user));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse<UserDTO>> login(@RequestHeader("email") String email, @RequestHeader("password") String password) {
        try {
            return commonResponseGenerator.successResponse(userService.login(email, password));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/change-password/request", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse<TokenAcces>> requestChangePassword(@RequestHeader("email")String email) {
        try {
            return commonResponseGenerator.successResponse(userService.requestChangePassword(email));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/change-password/valid-code", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse<TokenAcces>> validCode(@RequestParam("code") String code) {
        try {
            return commonResponseGenerator.successResponse(userService.validCode(code));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse<UserDTO>> changePassword(@RequestBody ChangePassword changePassword) {
        try {
            return commonResponseGenerator.successResponse(userService.changePassword(changePassword));
        } catch (Exception e) {
            return commonResponseGenerator.failResponse(e.getMessage());
        }
    }
}
