/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.List;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.Customer;
import model.Translatecountry;
import sessionBean.CustomerFacadeLocal;
import sessionBean.TranslatecountryFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@RequestScoped
public class register {
    @EJB
    private TranslatecountryFacadeLocal translatecountryFacade;
    @EJB
    private CustomerFacadeLocal customerFacade;

    @ManagedProperty("#{language}")
    private language lang;
    
    
    private String pseudo;
    private String password;
    private String confirm;
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
    
    private boolean erreurPseudo;
    private boolean erreurPassword;
    private boolean erreurEmail;
    
    public List<Translatecountry> getCountries () {
        
        return translatecountryFacade.findAllByLang(getLang().getLocale().getLanguage());
        
    }
    
    
    public String addCustomer() {     
        
        if (Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", email)) {
            if (password.equals(confirm)) {
                Customer cust = new Customer(this.getPseudo(), this.getPassword(), this.getName(), this.getFirstname(), this.getEmail(), this.getPhone(), this.getAdNumber(), this.getAdStreet(), this.getAdCity(), this.getAdZipCode(), Integer.parseInt(this.getAdCountry()));
                if(!this.getAdRegion().isEmpty())
                    cust.setAddressregion(this.getAdRegion());
                if(!this.getAdProvince().isEmpty())
                    cust.setAddressprovince(this.getAdProvince());
                List<Customer> testCust = customerFacade.findByLogin(this.getPseudo());
                if(testCust.isEmpty()) {
                    customerFacade.create(cust);
                    return "index";
                }
                else {
                    setErreurPseudo(true);
                    return "register";
                }
            }
            else {
                setErreurPassword(true);
                return "register";
            }
        }
        else {
            setErreurEmail(true);
            return "register";
        }
        
        
        
        
    }
    
    public String setBoldErreurPseudo () {
        if (isErreurPseudo()) {
            setErreurPseudo(false);
            return "erreur";
        }
        else {
            setErreurPseudo(false);
            return "hide";
        }
            
    }
    
    public String setBoldErreurPassword () {
        if (isErreurPassword()) {
            setErreurPassword(false);
            return "erreur";
        }
        else {
            setErreurPassword(false);
            return "hide";
        }
            
    }
    
    public String setBoldErreurEmail () {
        if (isErreurEmail()) {
            setErreurEmail(false);
            return "erreur";
        }
        else {
            setErreurEmail(false);
            return "hide";
        }
            
    }
    
    /**
     * Creates a new instance of register
     */
    public register() {
    }

    /**
     * @return the login
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
    
    /**
     * @return the erreurPseudo
     */
    public boolean isErreurPseudo() {
        return erreurPseudo;
    }

    /**
     * @param erreur the erreurPseudo to set
     */
    public void setErreurPseudo(boolean erreur) {
        this.erreurPseudo = erreur;
    }

    /**
     * @return the lang
     */
    public language getLang() {
        return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(language lang) {
        this.lang = lang;
    }

    /**
     * @return the confirm
     */
    public String getConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    /**
     * @return the erreurPassword
     */
    public boolean isErreurPassword() {
        return erreurPassword;
    }

    /**
     * @param erreurPassword the erreurPassword to set
     */
    public void setErreurPassword(boolean erreurPassword) {
        this.erreurPassword = erreurPassword;
    }

    /**
     * @return the erreurEmail
     */
    public boolean isErreurEmail() {
        return erreurEmail;
    }

    /**
     * @param erreurEmail the erreurEmail to set
     */
    public void setErreurEmail(boolean erreurEmail) {
        this.erreurEmail = erreurEmail;
    }
    
    
    
}
