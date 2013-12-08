/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.Customer;
import sessionBean.CustomerFacadeLocal;
import sessionBean.TranslatecountryFacadeLocal;

/**
 *
 * @author adrien
 */
@ManagedBean
@ViewScoped
public class changeCustomer {
    @EJB
    private CustomerFacadeLocal customerFacade;
private List<Customer> cust;
private String pseudo;
private String password;
private String name;
private String firstname;
private String email;
private String phone;
private int adNumber;
private String adStreet;
private String adCity;
private int adZipCode;
private String adCountry;
private String adRegion;
private String adProvince;
private int custId;
@ManagedProperty("#{connexion}")
private connexion connex;
    /**
     * Creates a new instance of changeCustomer
     */
    public changeCustomer() {
    }
    
        @PostConstruct
    public void init() {
        cust = connex.getCustomer();
        if(!cust.isEmpty())
        {
            for(Customer custom : cust)
            {
                setPseudo(custom.getLogin());
                setName(custom.getName());
                setFirstname(custom.getFirstname());
                setEmail(custom.getEmail());
                setPhone(custom.getPhone());
                setAdNumber(custom.getAddressnumber());
                setAdStreet(custom.getAddressstreet());
                setAdCity(custom.getAddresscity());
                setAdZipCode(custom.getAddresszipcode());
                setAdRegion(custom.getAddressregion());
                setAdProvince(custom.getAddressprovince());
                custId = custom.getId();
            }
        }
    }
    
    public String changeCustomer()
    {
        Customer cust = new Customer(this.getPseudo(), this.getPassword(), this.getName(), this.getFirstname(), this.getEmail(), this.getPhone(), this.getAdNumber(), this.getAdStreet(), this.getAdCity(), this.getAdZipCode(), Integer.parseInt(this.getAdCountry()));
        if(!this.getAdRegion().isEmpty())
            cust.setAddressregion(this.getAdRegion());
        if(!this.getAdProvince().isEmpty())
            cust.setAddressprovince(this.getAdProvince());
        cust.setId(custId);
        customerFacade.edit(cust);
        return "index";
    }
    
    /**
     * @return the connex
     */
    public connexion getConnex() {
        return connex;
    }

    /**
     * @param connex the connex to set
     */
    public void setConnex(connexion connex) {
        this.connex = connex;
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the adNumber
     */
    public int getAdNumber() {
        return adNumber;
    }

    /**
     * @param adNumber the adNumber to set
     */
    public void setAdNumber(int adNumber) {
        this.adNumber = adNumber;
    }

    /**
     * @return the adStreet
     */
    public String getAdStreet() {
        return adStreet;
    }

    /**
     * @param adStreet the adStreet to set
     */
    public void setAdStreet(String adStreet) {
        this.adStreet = adStreet;
    }

    /**
     * @return the adCity
     */
    public String getAdCity() {
        return adCity;
    }

    /**
     * @param adCity the adCity to set
     */
    public void setAdCity(String adCity) {
        this.adCity = adCity;
    }

    /**
     * @return the adZipCode
     */
    public int getAdZipCode() {
        return adZipCode;
    }

    /**
     * @param adZipCode the adZipCode to set
     */
    public void setAdZipCode(int adZipCode) {
        this.adZipCode = adZipCode;
    }

    /**
     * @return the adCountry
     */
    public String getAdCountry() {
        return adCountry;
    }

    /**
     * @param adCountry the adCountry to set
     */
    public void setAdCountry(String adCountry) {
        this.adCountry = adCountry;
    }

    /**
     * @return the adRegion
     */
    public String getAdRegion() {
        return adRegion;
    }

    /**
     * @param adRegion the adRegion to set
     */
    public void setAdRegion(String adRegion) {
        this.adRegion = adRegion;
    }

    /**
     * @return the adProvince
     */
    public String getAdProvince() {
        return adProvince;
    }

    /**
     * @param adProvince the adProvince to set
     */
    public void setAdProvince(String adProvince) {
        this.adProvince = adProvince;
    }
}
