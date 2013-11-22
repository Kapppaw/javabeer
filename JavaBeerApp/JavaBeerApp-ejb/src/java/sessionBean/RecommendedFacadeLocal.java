/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Recommended;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface RecommendedFacadeLocal {

    void create(Recommended recommended);

    void edit(Recommended recommended);

    void remove(Recommended recommended);

    Recommended find(Object id);

    List<Recommended> findAll();

    List<Recommended> findRange(int[] range);

    int count();
    
}
