/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.Translatecategory;
import sessionBean.TranslatecategoryFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@ViewScoped
public class category {
    @EJB
    private TranslatecategoryFacadeLocal translatecategoryFacade;
    
    @ManagedProperty("#{language}")
    private language lang;

    /**
     * Creates a new instance of category
     */
    public category() {
    }
    
    public List<Translatecategory> getCategories () {
        
        return translatecategoryFacade.findByLanguage(lang.getLocale().getLanguage());
        
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
