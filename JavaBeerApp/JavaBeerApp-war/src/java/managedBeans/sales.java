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
import model.Promo;
import model.Translateitem;
import sessionBean.PromoFacadeLocal;
import sessionBean.TranslateitemFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@ViewScoped
public class sales {
    @EJB
    private PromoFacadeLocal promoFacade;
    @EJB
    private TranslateitemFacadeLocal translateitemFacade;


    @ManagedProperty("#{language}")
    private language lang;
    
    private double pricePromo;
    private List<Translateitem> listItems;
    private Promo currentPromo;
    
    
    /**
     * Creates a new instance of sales
     */
    public sales() {
    }

    public List<Translateitem> getItems () {
        listItems = translateitemFacade.findCurrentPromoLang(lang.getLocale().getLanguage());
        currentPromo = promoFacade.findPromoCurrent();
        pricePromo = currentPromo.getReduction();
        for (Translateitem x:listItems) {
            x.getItemid().setPrice(x.getItemid().getPrice()*(100+pricePromo)/100);
        }
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
     * @return the pricePromo
     */
    public double getPricePromo() {
        return pricePromo;
    }

    /**
     * @param pricePromo the pricePromo to set
     */
    public void setPricePromo(double pricePromo) {
        this.pricePromo = pricePromo;
    }

    /**
     * @return the currentPromo
     */
    public Promo getCurrentPromo() {
        return currentPromo;
    }

    /**
     * @param currentPromo the currentPromo to set
     */
    public void setCurrentPromo(Promo currentPromo) {
        this.currentPromo = currentPromo;
    }
    
}
