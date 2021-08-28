package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAll(String accessToken) throws ResourceNotFoundExceotion;

    User register(User user) throws ResourceNotFoundExceotion;

    User login(String email, String password) throws ResourceNotFoundExceotion;

    Map<String, Boolean> delete(String id) throws ResourceNotFoundExceotion;
}
