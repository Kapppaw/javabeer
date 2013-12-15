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
import model.Promo;
import model.Recommended;
import sessionBean.ItemFacadeLocal;
import sessionBean.PromoFacadeLocal;
import sessionBean.RecommendedFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@ViewScoped
public class index {
    @EJB
    private PromoFacadeLocal promoFacade;
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
    
    private boolean bob;
    
    public List<Recommended> getAllItem() {
        List<Recommended> beers = recommendedFacade.findAll();
        Promo promo = promoFacade.findPromoCurrent();
        double price;
        for (Recommended x:beers) {
            if (promo.getCountrypromo().getId() == x.getItemid().getOrigin().getId()) {
                price = (x.getItemid().getPrice());
                price -= (promo.getReduction()*price/100);
                x.getItemid().setPrice(price);
            }
        }
        return beers;
    }
    
    public List<Item> getAllItemBestSales() {
        List<Item> beers = itemFacade.findAll();
        Promo promo = promoFacade.findPromoCurrent();
        double price;
        for (Item x:beers) {
            if (promo.getCountrypromo().getId() == x.getOrigin().getId()) {
                price = (x.getPrice());
                price -= (promo.getReduction()*price/100);
                x.setPrice(price);
            }
        }
        return beers;
    }
    
    @PostConstruct
    public void init() {
        listItemsRecommended = getAllItem();
    }

    /**
     * @return the bob
     */
    public boolean isBob() {
        return bob;
    }

    /**
     * @param bob the bob to set
     */
    public void setBob(boolean bob) {
        this.bob = bob;
    }
    
}
