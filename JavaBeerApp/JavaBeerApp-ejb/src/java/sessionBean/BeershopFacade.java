/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Beershop;

/**
 *
 * @author Thibault
 */
@Stateless
public class BeershopFacade extends AbstractFacade<Beershop> implements BeershopFacadeLocal {
    @PersistenceContext(unitName = "JavaBeerApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BeershopFacade() {
        super(Beershop.class);
    }
    
    
    public Beershop find(Integer id) {
        Query query;
        query = em.createNamedQuery("Beershop.findById");
        query.setParameter("id", id);
        return (Beershop)query.getSingleResult();
    }

}
