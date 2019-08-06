/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jordi.h2db.springboot.services;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import javax.transaction.Transactional;

import org.jordi.h2db.springboot.daos.UserRepository;
import org.jordi.h2db.springboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jordi
 */
@Service
public class UserService {

    @Autowired
    UserRepository repoUser;

    /**
     * create default womens
     * 
     * @param age
     */
    @Transactional
    public void getGetOlder(int age, int plus) {

        List<User> listUsers = repoUser.findByAgeGreaterThan(age);
        for (User user : listUsers) {
            user.setAge(user.getAge() + plus);
            repoUser.save(user);
        }
    }

    public void insertRandomWithSave(int number){

        for(int i=0;i<number;i++){
            User user = createRandomUser();
            repoUser.save(user);
        }

    }

    public void insertRandomWithSaveAll(int number){

        List<User> users = new ArrayList<User>();
        for(int i=0;i<number;i++){
            User user = createRandomUser();
            users.add(user);
        }
        repoUser.saveAll(users);

    }

    private static String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;

    }

    public static User createRandomUser() {
        User newUser = new User();
        newUser.setFirstName(randomString());
        newUser.setLastName(randomString());
        newUser.setAge(new Random().nextInt());
        return newUser;
    }

}