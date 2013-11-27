/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Beershop;
import model.Country;
import sessionBean.BeershopFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@SessionScoped
public class defaultTemplate {
    @EJB
    private BeershopFacadeLocal beershopFacade;
    
    private String phone;
    private String mail;
    private String street;
    private int numStreet;
    private int zipCode;
    private String city;
    private Country country;
    
    
    /**
     * Creates a new instance of defaultTemplate
     */
    public defaultTemplate() {
    }
    
    public void setParam () {
        Beershop param = beershopFacade.find(1);
        setStreet(param.getAddressstreet());
        setPhone(param.getPhone());
        setMail(param.getEmail());
        setNumStreet(param.getAddressnumber());
        setZipCode(param.getAddresszipcode());
        setCity(param.getAddresscity());
        setCountry(param.getAddresscountry());
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
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
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the numStreet
     */
    public int getNumStreet() {
        return numStreet;
    }

    /**
     * @param numStreet the numStreet to set
     */
    public void setNumStreet(int numStreet) {
        this.numStreet = numStreet;
    }

    /**
     * @return the zipCode
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }

  
    
    
}
