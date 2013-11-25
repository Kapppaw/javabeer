/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

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
    
    public String login() {
        Customer cust = customerFacade.connect(this.getPseudo(), this.getPassword());
        if (cust !=null) {
            setConnected(true);
            return "index";
        }
        else
            return "aboutus";
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
    
}
