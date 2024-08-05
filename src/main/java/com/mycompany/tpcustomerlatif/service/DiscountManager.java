/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.tpcustomerlatif.service;

import com.mycompany.tpcustomerlatif.entity.Discount;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 * Façade pour gérer les Discount
 *
 * @author Latif SAVADOGO
 */
@Named(value = "discountManager")
@RequestScoped
public class DiscountManager {

    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discounts.findAll");
        return query.getResultList();
    }

    @PersistenceContext(unitName = "discountPU")
    private EntityManager em;

    @Transactional
    public Discount update(Discount discount) {
        return em.merge(discount);
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

    /**
     * Creates a new instance of DiscountManager
     */
}
