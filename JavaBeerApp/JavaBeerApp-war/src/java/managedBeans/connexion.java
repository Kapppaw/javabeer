/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Thibault
 */
@ManagedBean
@SessionScoped
public class connexion {

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
        if (true) {
            setConnected(true);
            return "index";
        }
        else
            return "error";
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
