package com.jordi.hibernate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jordi.model.Proyecto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author SESCO31
 */
public class JPAH2JUnitTest {

    public JPAH2JUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

  
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void loadDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
        EntityManager em = emf.createEntityManager();
        

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.persist(new Proyecto("pia", "la pia no mola", true));
            em.persist(new Proyecto("was", "el was mola mas", true));
            em.persist(new Proyecto("mobile", "vaya kk de projecto", true));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

}
