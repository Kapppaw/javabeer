/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import java.util.List;
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
    public void edit (Customer entity) {
        Customer cust = em.find(Customer.class, entity.getId());
        if(!cust.getLogin().equals(entity.getLogin()))
            cust.setLogin(entity.getLogin());
        if(!cust.getPassword().equals(entity.getPassword()))
            cust.setPassword(entity.getPassword());
        if(!cust.getName().equals(entity.getName()))
            cust.setName(entity.getName());
        if(!cust.getFirstname().equals(entity.getFirstname()))
            cust.setFirstname(entity.getFirstname());
        if(!cust.getEmail().equals(entity.getEmail()))
            cust.setEmail(entity.getEmail());
        if(!cust.getPhone().equals(entity.getPhone()))
            cust.setPhone(entity.getPhone());
        if(cust.getAddressnumber() != entity.getAddressnumber())
            cust.setAddressnumber(entity.getAddressnumber());
        if(!cust.getAddressstreet().equals(entity.getAddressstreet()))
            cust.setAddressstreet(entity.getAddressstreet());
        if(!cust.getAddresscity().equals(entity.getAddresscity()))
            cust.setAddresscity(entity.getAddresscity());
        if(cust.getAddresszipcode() != entity.getAddresszipcode())
            cust.setAddresszipcode(entity.getAddresszipcode());
        cust.setAddressregion(entity.getAddressregion());
        cust.setAddressprovince(entity.getAddressprovince());
        if(!cust.getAddresscountry().equals(entity.getAddresscountry()))
            cust.setAddresscountry(entity.getAddresscountry());
        em.persist(cust);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    @Override
    public List<Customer> connect(String login,String password)
    {
        Query query;
        query = em.createNamedQuery("Customer.connect");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return query.getResultList();
    }
    
    @Override
    public List<Customer> findByLogin(String login) {
        Query query;
        query = em.createNamedQuery("Customer.findByLogin");
        query.setParameter("login", login);
        return query.getResultList();
    }
    
}
