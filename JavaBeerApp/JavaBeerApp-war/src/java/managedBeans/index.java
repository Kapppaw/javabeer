/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.ArrayList;
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
    private Promo currentPromo;
    
    public Promo getPromo () {
        
        return promoFacade.findPromoCurrent();
    }
    
    public List<Recommended> getAllItem() {
        List<Recommended> beers = recommendedFacade.findAll();
        Promo promo = promoFacade.findPromoCurrent();
        double price;
        for (Recommended x:beers) {
            //x.getItemid().setPromo(false);
            if (promo.getCountrypromo().getId() == x.getItemid().getOrigin().getId()) {
                price = (x.getItemid().getPrice());
                price -= (promo.getReduction()*price/100);
                x.getItemid().setPrice(price);
                
            }
        }
        
        List<Recommended> beers2 = new ArrayList<Recommended>();
        int i = 0;
        for (Recommended x:beers) {
            if (i == 3)
                break;
            beers2.add(x);
            i++;
        }
        return beers2;
    }
    
    //private boolean promo;
    
    public String setPromoVisible(Item item) {
        
        Promo promo = promoFacade.findPromoCurrent();
        if (promo.getCountrypromo().getId() == item.getOrigin().getId()) {
            return "item-sale-img";
        }
        else {
            return "item-sale-img hide";
        }
        
        
        
    }
    /*
    public boolean promotion (Item item) {
        Promo promo = promoFacade.findPromoCurrent();
        if (promo.getCountrypromo().getId() == item.getOrigin().getId()) {
            return true;
        }
        else {
            return false;
        }
    }
    */
    public List<Item> getAllItemBestSales() {
        List<Item> beers = itemFacade.findBestSales();
        Promo promo = promoFacade.findPromoCurrent();
        double price;
        for (Item x:beers) {
            if (promo.getCountrypromo().getId() == x.getOrigin().getId()) {
                price = (x.getPrice());
                price -= (promo.getReduction()*price/100);
                x.setPrice(price);
            }
        }
        List<Item> beers2 = new ArrayList<Item>();
        int i = 0;
        for (Item x:beers) {
            if (i == 3)
                break;
            beers2.add(x);
            i++;
        }
        return beers2;
    }
    
    @PostConstruct
    public void init() {
        listItemsRecommended = getAllItem();
    }

    /**
     * @return the promo
     *//*
    public boolean isPromo() {
        return promo;
    }
*/
    /**
     * @param promo the promo to set
     *//*
    public void setPromo(boolean promo) {
        this.promo = promo;
    }*/

    
    
}
