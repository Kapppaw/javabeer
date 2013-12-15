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
    
    @Override
    public List<Item> findBestSales () {
        Query query;
        query = em.createNamedQuery("Item.findBestSales");
        return query.getResultList();
    }
   
    @Override
    public void edit (Item entity) {
        Item item = em.find(Item.class, entity.getId());
        
        if(!item.getName().equals(entity.getName()))
            item.setName(entity.getName());
        if(!item.getDatearrived().equals(entity.getDatearrived()))
            item.setDatearrived(entity.getDatearrived());
        if(item.getPrice() != entity.getPrice())
            item.setPrice(entity.getPrice());
        if(item.getQuantitysale() != entity.getQuantitysale())
            item.setQuantitysale(entity.getQuantitysale());
        if(item.getDegalcohol() != entity.getDegalcohol())
            item.setDegalcohol(entity.getDegalcohol());
        if(item.getCapacity() != entity.getCapacity())
            item.setCapacity(entity.getCapacity());
        
        em.persist(item);
    }
    
    
}
