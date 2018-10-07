package com.jordi.hibernate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session
import org.junit.BeforeClass;
import org.junit.Test;

import com.jordi.model.*
import com.jordi.modelconstrain.Post2

public class JpaTestConstrain{
	private static Logger logger


	@BeforeClass
	static void setUpClass() {
		System.setProperty("log4j.configurationFile","log4j2-test.xml");
		logger = LogManager.getLogger(JpaTestConstrain.class);
		logger.debug("in before log4j")

		emf = Persistence.createEntityManagerFactory("h2")
	}
	private static EntityManagerFactory emf
	/**
	 * the entity has a auto key.
	 * This test is to see how after contrains unique exception 
	 * is not possible save, merge, the reason is that the object
	 * remains in session and it has unapropiate key. 
	 */
	@Test
	public void saveWithConstrains() {
		def original = new Post2(name:"name1",creationDate:new Date(),user:"user1",description:"uno")
		def repeated = new Post2(name:"name1",creationDate:new Date(),user:"user1",description:"dos")

		//store in isolated database original

		this.storePost2(original);
		EntityManager em = emf.createEntityManager()

		EntityTransaction tx = em.getTransaction()
		Session session = em.unwrap(Session.class)
		logger.debug("antes de persist post description uno")

		def  isException= false
		try {

			tx.begin()
			logger.debug("antes de persist post description dos")
			session.save(repeated)
			tx.commit()
		} catch (Exception e) {
			tx.rollback()
			e.printStackTrace()
			isException = true
			session.evict(repeated)
		} finally {
			//def postsaved = session.get(Post2,new Long(1))
			//assertEquals( "dos",original.description)
			session.close()
		}

		if(isException)
			this.updateWithHql(repeated)
			
		//finally get the element in antoher transacction
			
		em = emf.createEntityManager()
		def buscado = em.find(Post2.class, new Long(1))

		assertEquals( "dos",buscado.description)
	}
	/**
	 * method to update by hql in a separated transaccion
	 * @param post
	 * @return
	 */
	def updateWithHql(Post2 post) {
		EntityManager em = emf.createEntityManager()
		EntityTransaction tx = em.getTransaction()
		tx.begin()
		Session session = em.unwrap(Session.class)

		def updateQuery = """
				update Post2 set description=:description
					where name = :pname and user = :puser
			"""
		Query query=session.createQuery(updateQuery)
		query.setParameter("description", post.description)
		//query.setParameter("creationDate",repeated.getCreationDate())
		logger.debug("parametres  $post.name  $post.user")
		query.setParameter("pname", post.name)
		query.setParameter("puser", post.user)
		logger.debug(post.description)

		int modifications=query.executeUpdate();
		logger.debug("int de modifiacations"+modifications)
		session.flush()
		tx.commit()
		session.close()

	}
	/**
	 * stores and element of Post2 in database
	 * in isolate tranasacctin
	 */
	def storePost2(Post2 post) {
		EntityManager em = emf.createEntityManager()
		EntityTransaction tx = em.getTransaction()
		tx.begin()
		try {
			em.persist(post)
		} finally {
			tx.commit()
			em.close()
		}
	}

}
