/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface CustomerFacadeLocal {

    void create(Customer customer);

    void edit(Customer customer);

    void remove(Customer customer);

    Customer find(Object id);

    List<Customer> findAll();

    List<Customer> findRange(int[] range);

    int count();
   
    List<Customer> connect(String login, String password);
    List<Customer> findByLogin(String login);
}
