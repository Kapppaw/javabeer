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
import javax.faces.bean.SessionScoped;
import model.Item;
import model.Promo;
import model.Translatecategory;
import model.Translatecountry;
import model.Translateitem;
import sessionBean.PromoFacadeLocal;
import sessionBean.TranslatecategoryFacadeLocal;
import sessionBean.TranslatecountryFacadeLocal;
import sessionBean.TranslateitemFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@SessionScoped
public class beer {
    @EJB
    private PromoFacadeLocal promoFacade;
    @EJB
    private TranslatecountryFacadeLocal translatecountryFacade;
    @EJB
    private TranslatecategoryFacadeLocal translatecategoryFacade;
    @EJB
    private TranslateitemFacadeLocal translateitemFacade;

    @ManagedProperty("#{language}")
    private language lang;
    
    private int beerId;
    
    /**
     * Creates a new instance of beer
     */
    public beer() {
    }

    private List<Translatecategory> listCat;
    private Translatecountry origin;
    
    
    public List<Translatecategory> listCategories () {
        setListCat(translatecategoryFacade.findByIdLanguage(lang.getLocale().getLanguage(), beerId));
        return listCat;
    }
    
    public Translatecountry origine () {
        setOrigin(translatecountryFacade.findByIdLang(beerId, lang.getLocale().getLanguage()));
        return getOrigin();
    }
    
    public String isPromo (Item item) {
        Promo promo = promoFacade.findPromoCurrent();
        if (promo.getCountrypromo().getId() == item.getOrigin().getId()) {
            return "";
        }
        else {
            return "hide";
        }
    }
    
    public Translateitem getBeer() {
        Translateitem beer = translateitemFacade.findOne(beerId, lang.getLocale().getLanguage());
        Promo promo = promoFacade.findPromoCurrent();
        double price = beer.getItemid().getPrice();
        if (promo.getCountrypromo().getId() == beer.getItemid().getOrigin().getId()) {
            price -= (promo.getReduction()*price/100);
            beer.getItemid().setPrice(price);
        }
        return beer;
    }
    
    public String linkBeer (int id) {
        setBeerId(id);
        return "beer";
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
     * @return the listCat
     */
    public List<Translatecategory> getListCat() {
        return listCat;
    }

    /**
     * @param listCat the listCat to set
     */
    public void setListCat(List<Translatecategory> listCat) {
        this.listCat = translatecategoryFacade.findByIdLanguage(lang.getLocale().getLanguage(), beerId);
    }

    /**
     * @return the beerId
     */
    public int getBeerId() {
        return beerId;
    }

    /**
     * @param beerId the beerId to set
     */
    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }


    /**
     * @param origin the origin to set
     */
    public void setOrigin(Translatecountry origin) {
        this.origin = translatecountryFacade.findByIdLang(beerId, lang.getLocale().getLanguage());
    }

    /**
     * @return the origin
     */
    public Translatecountry getOrigin() {
        return origin;
    }
    
}
