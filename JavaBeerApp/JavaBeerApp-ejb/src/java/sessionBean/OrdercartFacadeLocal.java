/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Ordercart;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface OrdercartFacadeLocal {

    void create(Ordercart ordercart);

    void edit(Ordercart ordercart);

    void remove(Ordercart ordercart);

    Ordercart find(Object id);

    List<Ordercart> findAll();

    List<Ordercart> findRange(int[] range);

    int count();
    
}
