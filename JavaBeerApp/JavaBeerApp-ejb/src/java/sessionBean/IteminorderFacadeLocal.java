/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import data.Iteminorder;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface IteminorderFacadeLocal {

    void create(Iteminorder iteminorder);

    void edit(Iteminorder iteminorder);

    void remove(Iteminorder iteminorder);

    Iteminorder find(Object id);

    List<Iteminorder> findAll();

    List<Iteminorder> findRange(int[] range);

    int count();
    
}
