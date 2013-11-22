/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import data.Categoryoftheitem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface CategoryoftheitemFacadeLocal {

    void create(Categoryoftheitem categoryoftheitem);

    void edit(Categoryoftheitem categoryoftheitem);

    void remove(Categoryoftheitem categoryoftheitem);

    Categoryoftheitem find(Object id);

    List<Categoryoftheitem> findAll();

    List<Categoryoftheitem> findRange(int[] range);

    int count();
    
}
