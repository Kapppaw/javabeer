/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import java.util.List;
import model.Translateitem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Thibault
 */
@Stateless
public class TranslateitemFacade extends AbstractFacade<Translateitem> implements TranslateitemFacadeLocal {
    @PersistenceContext(unitName = "JavaBeerApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TranslateitemFacade() {
        super(Translateitem.class);
    }
    
    @Override
    public Translateitem findOne(int id, String lang) {
        
        Query query;
        query = em.createNamedQuery("Translateitem.findOne");
        query.setParameter("lang", lang);
        query.setParameter("id", id);
        return (Translateitem)query.getSingleResult();
    }
    
}
