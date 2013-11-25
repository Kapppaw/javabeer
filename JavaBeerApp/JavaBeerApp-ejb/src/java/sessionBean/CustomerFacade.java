/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Thibault
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {
    @PersistenceContext(unitName = "JavaBeerApp-ejbPU")
    private EntityManager em;

    @Override
    public void create (Customer entity) {
        em.persist(entity);
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    public Customer connect(String login,String password)
    {
        Query query;
        query = em.createNamedQuery("Customer.connect");
        query.setParameter("login", login);
        query.setParameter("password", password);
        if(query.getSingleResult()!=null)
            return (Customer) query.getSingleResult();
        else
            return null;
    }
    
}
