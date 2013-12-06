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
import model.Translateitem;
import sessionBean.TranslateitemFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@SessionScoped
public class research {
    @EJB
    private TranslateitemFacadeLocal translateitemFacade;

    @ManagedProperty("#{language}")
    private language lang;
    
    private List<Translateitem> listItems;

    /**
     * Creates a new instance of research
     */
    public research() {
    }
    
    private String search;
    
     public String searchItem () {
        getItems();
        return "research";
    }
     
     public List<Translateitem> getItems () {
        
        return translateitemFacade.searchItem(search, lang.getLocale().getLanguage());
        
    }
     
       /**
     * @return the research
     */
    public String getSearch() {
        return search;
    }

    /**
     * @param search the research to set
     */
    public void setSearch(String search) {
        this.search = search;
    }

    /**
     * @return the listItems
     */
    public List<Translateitem> getListItems() {
        return listItems;
    }

    /**
     * @param listItems the listItems to set
     */
    public void setListItems(List<Translateitem> listItems) {
        this.listItems = translateitemFacade.searchItem(search, lang.getLocale().getLanguage());
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
