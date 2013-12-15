/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Customer;
import model.Item;
import model.Iteminorder;
import model.Ordercart;
import model.Promo;
import sessionBean.ItemFacadeLocal;
import sessionBean.IteminorderFacadeLocal;
import sessionBean.OrdercartFacadeLocal;
import sessionBean.PromoFacadeLocal;

/**
 *
 * @author Thibault
 */
@ManagedBean
@SessionScoped
public class order {
    @EJB
    private OrdercartFacadeLocal ordercartFacade;
    @EJB
    private PromoFacadeLocal promoFacade;
    @EJB
    private IteminorderFacadeLocal iteminorderFacade;
    @EJB
    private ItemFacadeLocal itemFacade;

    private HashMap<Integer, Iteminorder>  orderMap = new HashMap();
    private int qte;
    private int nbItems;
    
    @ManagedProperty("#{connexion}")
    private connexion connex;
    
    /**
     * Creates a new instance of order
     */
    public order() {
        
    }
    
    public void addItem (int id) {
        Item currentItem = itemFacade.find(id);
        Promo promo = promoFacade.findPromoCurrent();
        double price = currentItem.getPrice();
        boolean find = false;
        if (promo.getCountrypromo().getId() == currentItem.getOrigin().getId()) {
            price -= (promo.getReduction()*price/100);

        }
        for(Entry<Integer, Iteminorder> item : orderMap.entrySet()) {
            if (item.getKey() == id) {
                item.getValue().setQuantity(item.getValue().getQuantity() + qte);
                find = true;
            }
                
        }
        if (find == false) {
            nbItems++;
            Iteminorder item = new Iteminorder(qte, price, currentItem);
            orderMap.put(id, item);
        }
        
        
        
    }
    
    public void deleteItem (int id) {
        orderMap.remove(id);
        nbItems--;
    }
    
    public void downQte (int id) {
        orderMap.get(id).setQuantity(orderMap.get(id).getQuantity() - 1);
        if (orderMap.get(id).getQuantity() == 0) {
            deleteItem(id);
        }
    }
    
    public void upQte (int id) {
        orderMap.get(id).setQuantity(orderMap.get(id).getQuantity() + 1);
    }

    public String validCommand() {
        GregorianCalendar today = new java.util.GregorianCalendar();
        Customer cust = new Customer(connex.getIdCust());
        Ordercart cart = new Ordercart(today.getTime(), cust);
        ordercartFacade.create(cart);
        
        for(Entry<Integer, Iteminorder> currentItem : orderMap.entrySet()) {
            Iteminorder item = currentItem.getValue();
            item.setOrdercartid(cart);
            iteminorderFacade.create(item);
            Item updateItem = new Item(item.getItemid().getId(), item.getItemid().getName(), item.getItemid().getDatearrived(), item.getItemid().getPrice(), item.getItemid().getCapacity(), item.getItemid().getDegalcohol(), item.getItemid().getQuantitysale() + item.getQuantity());
            itemFacade.edit(updateItem);
        }
        orderMap = new HashMap<>();
        nbItems = 0;
        
        return "orderComplete";
    }
    
    /**
     * @return the qte
     */
    public int getQte() {
        return qte;
    }

    /**
     * @param qte the qte to set
     */
    public void setQte(int qte) {
        this.qte = qte;
    }

    /**
     * @return the orderMap
     */
    public HashMap<Integer, Iteminorder> getOrderMap() {
        return orderMap;
    }

    /**
     * @param orderMap the orderMap to set
     */
    public void setOrderMap(HashMap<Integer, Iteminorder> orderMap) {
        this.orderMap = orderMap;
    }
    
    public List<Iteminorder> getMapAsList (){
         return new ArrayList<Iteminorder> (orderMap.values());       
    }

    /**
     * @return the nbItems
     */
    public int getNbItems() {
        return nbItems;
    }

    /**
     * @param nbItems the nbItems to set
     */
    public void setNbItems(int nbItems) {
        this.nbItems = nbItems;
    }

    /**
     * @return the connex
     */
    public connexion getConnex() {
        return connex;
    }

    /**
     * @param conne the connex to set
     */
    public void setConnex(connexion conne) {
        this.connex = conne;
    }
       
   
    
}
