/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import java.util.GregorianCalendar;
import model.Promo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Thibault
 */
@Stateless
public class PromoFacade extends AbstractFacade<Promo> implements PromoFacadeLocal {
    @PersistenceContext(unitName = "JavaBeerApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromoFacade() {
        super(Promo.class);
    }
    
    @Override
    public Promo findPromoCurrent () {
        Query query;
        query = em.createNamedQuery("Promo.findPromoCurrent");
        GregorianCalendar today = new java.util.GregorianCalendar();
        query.setParameter("today", today.getTime());
        return (Promo)query.getSingleResult();
    }
    
}
