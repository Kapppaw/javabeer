/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import java.util.GregorianCalendar;
import java.util.List;
import model.Recommended;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Thibault
 */
@Stateless
public class RecommendedFacade extends AbstractFacade<Recommended> implements RecommendedFacadeLocal {
    @PersistenceContext(unitName = "JavaBeerApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecommendedFacade() {
        super(Recommended.class);
    }
    
        
    @Override
    public List<Recommended> findAll() {
        Query query;
        query = em.createNamedQuery("Recommended.findAll");
        GregorianCalendar today = new java.util.GregorianCalendar();
        query.setParameter("today", today.getTime());
        return query.getResultList();
    }
}
