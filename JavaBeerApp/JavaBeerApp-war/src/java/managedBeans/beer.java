/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.List;
import java.util.Locale.Category;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Translatecategory;
import model.Translateitem;
import sessionBean.TranslatecategoryFacadeLocal;
import sessionBean.TranslateitemFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@ViewScoped
public class beer {
    @EJB
    private TranslatecategoryFacadeLocal translatecategoryFacade;
    @EJB
    private TranslateitemFacadeLocal translateitemFacade;

    @ManagedProperty("#{language}")
    private language lang;
    
    /**
     * Creates a new instance of beer
     */
    public beer() {
    }
    
    private Translateitem beer;
    private List<Translatecategory> listCat;
    
    public List<Translatecategory> aMoi () {
        setListCat(translatecategoryFacade.findByIdLanguage(lang.getLocale().getLanguage(), Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("beerid"))));
        return listCat;
    }
    
    public Translateitem getBeer() {
        String beerId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("beerid");
        return translateitemFacade.findOne(Integer.parseInt(beerId), lang.getLocale().getLanguage());
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
        this.listCat = translatecategoryFacade.findByIdLanguage(lang.getLocale().getLanguage(), Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("beerid")));
    }
    
}
