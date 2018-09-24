package com.jordi.hibernate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jordi.model.*
import com.jordi.model.Post
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

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class JpaTest {
    private static Logger logger 


    @BeforeClass
   static void setUpClass() {
        System.setProperty("log4j.configurationFile","log4j2-test.xml");
        logger = LogManager.getLogger(JpaTest.class);
        logger.debug("in before log4j")

         EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2")
        EntityManager em = emf.createEntityManager()
        this.entityManager = em
    }
    private static EntityManager entityManager

    @After
    public void tearDown() {
    }

    @Test
    public void loadDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2")
        EntityManager em = emf.createEntityManager()

        EntityTransaction tx = em.getTransaction()
        tx.begin()
        try {
            em.persist(new Post(name:"my blog",creationDate:new Date()))
            em.flush()
            tx.commit()
        } catch (Exception e) {
            e.printStackTrace()
            tx.rollback();
        } finally {
            em.close()
            emf.close()
        }
    println 'ENJOY Groovy JUNIT test with hibernate' 
	logger.debug("enjoy in logger")
    }
	
	@Test
	def void "save detached"() {
		try {
		println "save detached with merge"
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2")
		EntityManager em1 = emf.createEntityManager()
		
		def post = new Post(name:"my blog1",creationDate:new Date())
		
		em1.persist(post)
		em1.close()
		
		EntityManager em2 = emf.createEntityManager()
		em2.persist(post)
		em2.close();
		} catch (javax.persistence.PersistenceException e) {
			assertTrue(true)
		} catch (Exception) {
			assertTrue(false)
		}
		

	}
}
