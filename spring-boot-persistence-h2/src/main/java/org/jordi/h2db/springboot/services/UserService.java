/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jordi.h2db.springboot.services;

import java.util.List;

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

}