/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.Translateitem;
import model.Translatepromo;
import sessionBean.TranslateitemFacadeLocal;
import sessionBean.TranslatepromoFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@ViewScoped
public class sales {
    @EJB
    private TranslateitemFacadeLocal translateitemFacade;


    @ManagedProperty("#{language}")
    private language lang;
    
    private double newPrice;
    private List<Translateitem> listItems;
    
    
    /**
     * Creates a new instance of sales
     */
    public sales() {
    }

    public List<Translateitem> getItems () {
        listItems = translateitemFacade.findCurrentPromoLang(lang.getLocale().getLanguage());
        
        return listItems;
        
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
     * @return the newPrice
     */
    public double getNewPrice() {
        return newPrice;
    }

    /**
     * @param newPrice the newPrice to set
     */
    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
    
}
