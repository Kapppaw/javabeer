/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Commentitem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface CommentitemFacadeLocal {

    void create(Commentitem commentitem);

    void edit(Commentitem commentitem);

    void remove(Commentitem commentitem);

    Commentitem find(Object id);

    List<Commentitem> findAll();

    List<Commentitem> findRange(int[] range);

    int count();
    
}
