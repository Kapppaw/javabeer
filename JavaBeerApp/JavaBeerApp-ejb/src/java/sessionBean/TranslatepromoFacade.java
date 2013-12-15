/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import java.util.List;
import model.Translatepromo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Thibault
 */
@Stateless
public class TranslatepromoFacade extends AbstractFacade<Translatepromo> implements TranslatepromoFacadeLocal {
    @PersistenceContext(unitName = "JavaBeerApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TranslatepromoFacade() {
        super(Translatepromo.class);
    }
    
    @Override
    public List<Translatepromo> findCurrentLang(String lang) {
        
        Query query;
        query = em.createNamedQuery("Translatepromo.findCurrentLang");
        query.setParameter("lang", lang);
        return query.getResultList();
    }
    
}
