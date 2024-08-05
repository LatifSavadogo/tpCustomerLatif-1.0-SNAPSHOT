/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.tpcustomerlatif.service;

import com.mycompany.tpcustomerlatif.entity.Customer;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Latif SAVADOGO
 */
@Named(value = "entityManager")
@RequestScoped
public class EntityManager {

    public List<Customer> getAllEntity() {
        Query query = em.createNamedQuery("Entity.findAll");
        return query.getResultList();
    }

    @PersistenceContext(unitName = "entityPU")
    private EntityManager em;
    
    @Transactional
    public Entity upate(Entity entity) {
        return em.merge(entity);
    }
    
    @Transactional
    public void persist(Entity entity) {
        em.persist(entity);
    }
    
    public Entity update(Entity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Creates a new instance of EntityManager
     */
    public EntityManager() {
    }

    private Query createNamedQuery(String entityfindAll) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Entity merge(Entity entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
