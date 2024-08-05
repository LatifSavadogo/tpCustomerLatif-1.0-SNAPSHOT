/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.tpcustomerlatif.jsf;

import com.mycompany.tpcustomerlatif.entity.Customer;
import com.mycompany.tpcustomerlatif.service.CustomerManager;
import jakarta.inject.Named;
//import jakarta.enterprise.context.Dependent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

/**
 *
 * @author Latif SAVADOGO
 */
@Named(value = "customerDetailsBean")
//@Dependent
@ViewScoped
public class CustomerDetailsBean implements Serializable{
    private int idCustomer;
    private Customer customer;
    
    @Inject
    private CustomerManager customerManager;
    
    public int getIdCustomer(){
        return idCustomer;
    }
    
    public void setIdCustomer(int idCustomer){
        this.idCustomer = idCustomer;
    }
    /**
     * Retourne les details du client courant(contenu dans l'attribut customer de cette classe)
     * Creates a new instance of CustomerDetailsBean
     */
    
    public Customer getCustomer(){
        return customer;
    }
    
    /**
     * Action handler - met a jour dans la bd les données du client
     * contenu dans la variable d'instance customer.
     * @return la prochaine page à afficher, celle qui affiche la liste des clients
     */
    public String update(){
        //Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }
    public void loadCustomer(){
        this.customer = customerManager.findById(idCustomer);
    }
    
    /*public Customer findById(int idCustomer){
        return em.find(Customer.class, idCustomer);
    }*/
    public CustomerDetailsBean() {
    }
    
}
