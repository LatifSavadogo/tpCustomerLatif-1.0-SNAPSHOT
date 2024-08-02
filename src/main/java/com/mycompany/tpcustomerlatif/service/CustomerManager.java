/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tpcustomerlatif.service;

import com.mycompany.tpcustomerlatif.entity.Customer;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;



/**
 * @RequestScoped
 * Gère la persistance des Customers
 *Façade pour gerer les customers
 * @author Latif SAVADOGO
 */
@RequestScoped //L'annotation @RequestScoped indique qu'une instance de la classe sera un bean CDI
public class CustomerManager {
    
    // Methodes qui retourne la liste de tous les customers
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }
    
    /**
     * @PersistenceContext qui provoquera l'injection de l'EntityManager
     * "customerPU", correspond au nom donné dans le fichier persistence.xml ; 
     * il correspond à l'unité de persistance qui représente la source de données de nom JNDI "jdbc/customer"
     */
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    /**
     *  *  @Transactional car on va modifier la base de donnée 
     * et toute modification doit être obligatoirement faite dans une transaction
     * */
    @Transactional
    public Customer upate(Customer customer){
        return em.merge(customer);
    }
    
    @Transactional
    public void persist(Customer customer){
        em.persist(customer);
    }
}
