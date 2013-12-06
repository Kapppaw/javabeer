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
import model.Translatecategory;
import model.Translateitem;
import sessionBean.TranslateitemFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@ViewScoped
public class news {
    @EJB
    private TranslateitemFacadeLocal translateitemFacade;

    @ManagedProperty("#{language}")
    private language lang;
    
    private List<Translateitem> listBeer;
    
    /**
     * Creates a new instance of news
     */
    public news() {
    }

    public List<Translateitem> getItems () {
        
        return translateitemFacade.findLast(lang.getLocale().getLanguage());
        
    }
    
    /**
     * @return the listBeer
     */
    public List<Translateitem> getListBeer() {
        return listBeer;
    }

    /**
     * @param listBeer the listBeer to set
     */
    public void setListBeer(List<Translateitem> listBeer) {
        this.listBeer = listBeer;
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
    
    
    
}
