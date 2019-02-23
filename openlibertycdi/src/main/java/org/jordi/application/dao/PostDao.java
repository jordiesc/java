package org.jordi.application.dao;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jordi.model.Post;

@RequestScoped
public class PostDao {

     @PersistenceContext(name = "jpa-unit")
    private EntityManager em;


    public void createPost(Post post){
        System.out.println("create Post Dao");
        em.persist(post);
        
    }
}