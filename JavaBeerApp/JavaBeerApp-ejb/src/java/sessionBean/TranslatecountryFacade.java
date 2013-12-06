/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import java.util.List;
import model.Translatecountry;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Thibault
 */
@Stateless
public class TranslatecountryFacade extends AbstractFacade<Translatecountry> implements TranslatecountryFacadeLocal {
    @PersistenceContext(unitName = "JavaBeerApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TranslatecountryFacade() {
        super(Translatecountry.class);
    }
    
    @Override
    public Translatecountry findByIdLang (int id, String lang) {
        Query query;
        query = em.createNamedQuery("Translatecountry.findByIdLang");
        query.setParameter("lang", lang);
        query.setParameter("id", id);
        return (Translatecountry)query.getSingleResult();
    }

    @Override
    public Translatecountry findByParamIdLang (int id, String lang) {
        Query query;
        query = em.createNamedQuery("Translatecountry.findByIdLang");
        query.setParameter("lang", lang);
        query.setParameter("id", id);
        return (Translatecountry)query.getSingleResult();
    }
    
    @Override
    public List<Translatecountry> findAllByLang (String lang) {
        Query query;
        query = em.createNamedQuery("Translatecountry.findAllByLang");
        query.setParameter("lang", lang);
        return query.getResultList();
    }
    
}
