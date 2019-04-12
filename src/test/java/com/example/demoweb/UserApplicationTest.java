package com.example.demoweb;

import com.example.demoweb.model.UserApplication;
import com.example.demoweb.repo.IUserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTest {

    @Autowired
    private IUserRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    public void registerUser() {
        UserApplication u = new UserApplication();
        u.setName("jamb");
        u.setPassword(encoder.encode("123"));
//        u.setPassword("123");
        UserApplication retorno = repo.save(u);

        assertTrue(retorno.getPassword().equalsIgnoreCase(u.getPassword()));
    }

}
