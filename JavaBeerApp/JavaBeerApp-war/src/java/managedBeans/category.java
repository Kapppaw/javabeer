/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import model.Item;
import model.Translatecategory;
import sessionBean.ItemFacadeLocal;
import sessionBean.TranslatecategoryFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@ViewScoped
public class category {
    @EJB
    private ItemFacadeLocal itemFacade;
    @EJB
    private TranslatecategoryFacadeLocal translatecategoryFacade;
    
    @ManagedProperty("#{language}")
    private language lang;
    
    private List<Item> listItems;

    /**
     * Creates a new instance of category
     */
    public category() {
    }
    
    public List<Translatecategory> getCategories () {
        
        return translatecategoryFacade.findByLanguage(lang.getLocale().getLanguage());
        
    }
    
    public List<Item> getAllItem() {
        return itemFacade.findAll();
    }

    public void getItemsByCat (int idCat) {
        listItems = itemFacade.findByCat(idCat);
    }
    
    @PostConstruct
    public void init() {
        listItems = getAllItem();
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
     * @return the listItems
     */
    public List<Item> getListItems() {
        return listItems;
    }

    /**
     * @param listItems the listItems to set
     */
    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }
    
}
