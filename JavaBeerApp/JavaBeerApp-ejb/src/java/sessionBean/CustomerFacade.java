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
    /*
    @Override
    public void edit(Customer entity) {
        em.merge(entity);
    }

    @Override
    public void remove(Customer entity) {
        em.remove(em.merge(entity));
    }

    public Customer find(Integer id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> findAll() {
        return em.find(Customer.class, this)
    }

    List<Customer> findRange(int[] range);

    int count();
    */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
}
