package com.service.lazimu.web.service;

import com.service.lazimu.enggine.emailConfig.Email;
import com.service.lazimu.enggine.exception.ResourceNotFoundExceotion;
import com.service.lazimu.web.model.ChangePassword;
import com.service.lazimu.web.model.TokenAcces;
import com.service.lazimu.web.model.User;
import com.service.lazimu.web.repository.TokenAccesRepository;
import com.service.lazimu.web.repository.UserRepository;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.*;

@Service
public class UserImpl implements UserService {

    @Autowired
    private Email send;

    @Autowired
    private TokenAccesRepository tokenAccesRepository;

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

    @Override
    public TokenAcces requestChangePassword(String email) throws TemplateException, MessagingException, IOException, ResourceNotFoundExceotion {
        var ASLKASK = userRepository.findByEmailAddress(email);
        if (ASLKASK == null) {
            throw new ResourceNotFoundExceotion("EMAIL NOT FOUND");
        }
        Random random = new Random();
        int code = random.nextInt(1_000_000);
        TokenAcces create = new TokenAcces();
        create.setEmail(ASLKASK.getEmailAddress());
        create.setExpridedDate(new Date(System.currentTimeMillis() + 900_000));
        create.setCode(String.valueOf(code));
        var cke = tokenAccesRepository.findByEmail(ASLKASK.getEmailAddress());
        if (cke != null) {
            tokenAccesRepository.deleteById(cke.getId());
        }
        tokenAccesRepository.save(create);
        Map<String, Object> model = new HashMap<>();
        model.put("username", ASLKASK.getUsername());
        model.put("code", create.getCode());
        send.sendEmail(email, model);
        return create;
    }

    @Override
    public TokenAcces validCode(String code) throws ResourceNotFoundExceotion {
        var KSKK = tokenAccesRepository.findByCode(code);
        if (KSKK == null) {
            throw new ResourceNotFoundExceotion("ACCESS CODE NOT FOUND");
        }
        if (KSKK.getExpridedDate().before(new Date())) {
            throw new ResourceNotFoundExceotion("ACCESS CODE EXPIRED");
        }
        return KSKK;
    }

    @Override
    public User changePassword(ChangePassword confirm) throws ResourceNotFoundExceotion {
        var KSKK = tokenAccesRepository.findByCode(confirm.getCode());
        if (KSKK == null) {
            throw new ResourceNotFoundExceotion("ACCESS CODE NOT FOUND");
        }
        if (KSKK.getExpridedDate().before(new Date())) {
            throw new ResourceNotFoundExceotion("ACCESS CODE EXPIRED");
        }
        if (!confirm.getNewPassword().equals(confirm.getConfirmPassword())) {
            throw new ResourceNotFoundExceotion("MUST BE THE SAME");
        }
        var update = userRepository.findByEmailAddress(KSKK.getEmail());
        update.setPasswordHash(confirm.getNewPassword());
        return userRepository.save(update);
    }
}
