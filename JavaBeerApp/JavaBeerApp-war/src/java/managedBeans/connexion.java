/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Customer;
import sessionBean.CustomerFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@SessionScoped
public class connexion {
    @EJB
    private CustomerFacadeLocal customerFacade;

    private String pseudo;
    private String password;
    private boolean connected = false;
    private boolean erreur = false;
    private List<Customer> cust;
    private int idCust;
    /**
     * Creates a new instance of connexion
     */
    public connexion() {
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<Customer> getCustomer()
    {
        return cust = customerFacade.connect(this.getPseudo(), this.getPassword());
    }
    
    public String login() {
        cust = getCustomer();
        if (!cust.isEmpty()) {
            setConnected(true);
            setIdCust((int) cust.get(0).getId());
            return "index";
        }
        else {
            setErreur(true);
            return "register";
        }
            
    }
    
    public String logout() {
        setConnected(false);
        return "index";
    }

    /**
     * @return the connected
     */
    public boolean isConnected() {
        return connected;
    }

    /**
     * @param connected the connected to set
     */
    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    
    
    public String outcomeAccount() {
        
        if (isConnected())
            return "account";
        else
            return "register";
        
    }

    /**
     * @return the erreur
     */
    public boolean isErreur() {
        return erreur;
    }

    /**
     * @param erreur the erreur to set
     */
    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }
    
    public String setBoldErreur () {
        if (erreur) {
            setErreur(false);
            return "erreur";
        }
        else {
            setErreur(false);
            return "hide";
        }
            
    }

    /**
     * @return the idCust
     */
    public int getIdCust() {
        return idCust;
    }

    /**
     * @param idCust the idCust to set
     */
    public void setIdCust(int idCust) {
        this.idCust = idCust;
    }

    
    
}
