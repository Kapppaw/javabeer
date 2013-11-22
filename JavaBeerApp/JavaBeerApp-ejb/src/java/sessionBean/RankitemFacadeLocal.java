/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Rankitem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface RankitemFacadeLocal {

    void create(Rankitem rankitem);

    void edit(Rankitem rankitem);

    void remove(Rankitem rankitem);

    Rankitem find(Object id);

    List<Rankitem> findAll();

    List<Rankitem> findRange(int[] range);

    int count();
    
}
