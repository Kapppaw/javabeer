/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Beershop;
import model.Country;
import model.Translatecountry;
import sessionBean.BeershopFacadeLocal;
import sessionBean.TranslatecountryFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@SessionScoped
public class defaultTemplate {
    @EJB
    private TranslatecountryFacadeLocal translatecountryFacade;
    @EJB
    private BeershopFacadeLocal beershopFacade;
    
    @ManagedProperty("#{language}")
    private language lang;
    
    private Beershop param;
    
    private Translatecountry origin;
    
    
    
    
    
    /**
     * Creates a new instance of defaultTemplate
     */
    public defaultTemplate() {
    }

    
    
    
    public Translatecountry origine () {
        setOrigin(translatecountryFacade.findByParamIdLang(1, lang.getLocale().getLanguage()));
        return getOrigin();
    }
    
    public Beershop beershopParam () {
        setParam(beershopFacade.findByIdLang(1, getLang().getLocale().getLanguage()));
        return param;
    }

    
    /**
     * @return the param
     */
    public Beershop getParam() {
        return param;
    }

    /**
     * @param param the param to set
     */
    public void setParam(Beershop param) {
        this.param = beershopFacade.findByIdLang(1, getLang().getLocale().getLanguage());
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
     * @return the origin
     */
    public Translatecountry getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(Translatecountry origin) {
        this.origin = origin;
    }



  
    
    
}
