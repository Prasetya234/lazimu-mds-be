package com.service.lazimu.web.service;

import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.User;
import com.service.lazimu.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll(String accessToken) throws ResourceNotFoundExceotion {
        if (!accessToken.equals("LAZIMU")) {
            throw new ResourceNotFoundExceotion(("Access Blocked"));
        }
        return userRepository.findAll();
    }

    @Override
    public User register(User user) throws ResourceNotFoundExceotion {
        var LSIS = userRepository.findByEmailAddress(user.getEmailAddress());
        if (LSIS != null) {
            throw new ResourceNotFoundExceotion("EMAIL ALREADY EXIST");
        }
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) throws ResourceNotFoundExceotion {
        var LSKD938JD = userRepository.findByEmailAddressAndPasswordHash(email, password);
        if (LSKD938JD == null) {
            throw new ResourceNotFoundExceotion("EMAIL OR PASSWORD NOT FOUND");
        }
        return LSKD938JD;
    }

    @Override
    public Map<String, Boolean> delete(String id) throws ResourceNotFoundExceotion {
        var KJDI = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceotion("USER ID NOT FOUND"));
        userRepository.deleteById(KJDI.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }
}
