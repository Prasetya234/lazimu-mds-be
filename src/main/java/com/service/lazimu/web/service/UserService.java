package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.ChangePassword;
import com.service.lazimu.web.model.TokenAcces;
import com.service.lazimu.web.model.User;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAll(String accessToken) throws ResourceNotFoundExceotion;

    User register(User user) throws ResourceNotFoundExceotion;

    User login(String email, String password) throws ResourceNotFoundExceotion;

    Map<String, Boolean> delete(String id) throws ResourceNotFoundExceotion;

    TokenAcces requestChangePassword(String email) throws TemplateException, MessagingException, IOException, ResourceNotFoundExceotion;

    TokenAcces validCode(String code) throws ResourceNotFoundExceotion;

    User changePassword(ChangePassword confirm) throws ResourceNotFoundExceotion;
}
