/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Posts;
import model.Users;

/**
 *
 * @author kasettilameri
 */
@Stateless
public class DBcontrol {
    @PersistenceContext
    private EntityManager em;
    
    public DBcontrol() {   
    }
    public List<Users> getAll() {
        List<Users> list = em.createNamedQuery("Users.findAll").getResultList();
        return list;
    }
    
    public Users insert(Users u) {
        em.persist(u);
        return u;
    }
    
    public Posts upload(Posts p) {
        em.persist(p);
        return p;
    }
    public List<Posts> getAllPosts() {
        List<Posts> lst = em.createNamedQuery("Posts.findAll").getResultList();
        return lst;
    }
    
    public void update(Users u) {
        em.merge(u);
    }
    
    public void delete(Users u) {
        em.remove(em.merge(u));
    }
}
