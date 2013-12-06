/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import java.util.List;
import java.util.Locale;
import model.Translatecategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Thibault
 */
@Stateless
public class TranslatecategoryFacade extends AbstractFacade<Translatecategory> implements TranslatecategoryFacadeLocal {
    @PersistenceContext(unitName = "JavaBeerApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TranslatecategoryFacade() {
        super(Translatecategory.class);
    }
    
    @Override
    public List<Translatecategory> findByLanguage(String lang) {
        Query query;
        query = em.createNamedQuery("Translatecategory.findByLanguage");
        query.setParameter("lang", lang);
        return query.getResultList();
    }
    
    @Override
    public List<Translatecategory> findByIdLanguage(String lang, int id) {
        Query query;
        query = em.createNamedQuery("Translatecategory.findByIdLanguage");
        query.setParameter("lang", lang);
        query.setParameter("id", id);
        return query.getResultList();
    }
    
}
