/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpCustomerAntenainaRANDRIANANTOANDRO.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import mg.itu.tpCustomerAntenainaRANDRIANANTOANDRO.ejb.CustomerManager;
import mg.itu.tpCustomerAntenainaRANDRIANANTOANDRO.entities.Customer;

/**
 *
 * @author Antenaina
 */
/**
 * Backing bean pour la page customerDetails.xhtml.
 */
@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @EJB
    private CustomerManager customerManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }
}
