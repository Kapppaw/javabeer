/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import java.util.List;
import model.Item;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Thibault
 */
@Stateless
public class ItemFacade extends AbstractFacade<Item> implements ItemFacadeLocal {
    @PersistenceContext(unitName = "JavaBeerApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemFacade() {
        super(Item.class);
    }
    
    @Override
    public List<Item> findByCat(int id) {
        Query query;
        query = em.createNamedQuery("Item.findByCat");
        query.setParameter("idCat", id);
        return query.getResultList();
    }
    
    public List<Item> findBestSales () {
        Query query;
        query = em.createNamedQuery("Item.findBestSales");
        return query.getResultList();
    }
    
    
}
