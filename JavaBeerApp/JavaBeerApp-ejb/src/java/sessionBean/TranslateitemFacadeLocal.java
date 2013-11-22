/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Translateitem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface TranslateitemFacadeLocal {

    void create(Translateitem translateitem);

    void edit(Translateitem translateitem);

    void remove(Translateitem translateitem);

    Translateitem find(Object id);

    List<Translateitem> findAll();

    List<Translateitem> findRange(int[] range);

    int count();
    
}
