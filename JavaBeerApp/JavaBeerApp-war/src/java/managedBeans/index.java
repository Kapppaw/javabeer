/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Item;
import model.Recommended;
import sessionBean.ItemFacadeLocal;
import sessionBean.RecommendedFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@ViewScoped
public class index {
    @EJB
    private ItemFacadeLocal itemFacade;
    @EJB
    private RecommendedFacadeLocal recommendedFacade;
    

    /**
     * Creates a new instance of index
     */
    public index() {
    }
    
    private List<Recommended> listItemsRecommended;
    private List<Item> listItemsBestSales;
    
    public List<Recommended> getAllItem() {
        return recommendedFacade.findAll();
    }
    
    public List<Item> getAllItemBestSales() {
        return itemFacade.findBestSales();
    }
    
    @PostConstruct
    public void init() {
        listItemsRecommended = getAllItem();
    }
    
}
