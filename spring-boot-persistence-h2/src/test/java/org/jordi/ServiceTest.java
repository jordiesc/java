package org.jordi;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.nio.charset.Charset;
import java.util.Random;

import org.jordi.h2db.springboot.SpringBootH2Application;
import org.jordi.h2db.springboot.daos.UserRepository;
import org.jordi.h2db.springboot.models.User;
import org.jordi.h2db.springboot.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootH2Application.class)
public class ServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Before
    public void inserteDB() {

        User user1 = new User();
        user1.setFirstName("Rachel");
        user1.setLastName("Fernandez");
        user1.setAge(10);

        User user2 = new User();
        user2.setFirstName("Joana");
        user2.setLastName("Fernandez");
        user2.setAge(10);

        userRepository.save(user1);
        userRepository.save(user2);

    }

    @Test
    public void testTransaccion() {
        userService.getGetOlder(1, 1);
        assertTrue("message", true);

    }

    @Test
    public void batchInsert() {
        // RandomStringUtils
    }

    @Test
    public void randomUser() {

       User user = this.userService.createRandomUser();
       assertNotNull(user);
       assertNotNull(user.getFirstName());

    }

    @Test
    public void testsave(){
        this.userService.insertRandomWithSave(10);
    }


}