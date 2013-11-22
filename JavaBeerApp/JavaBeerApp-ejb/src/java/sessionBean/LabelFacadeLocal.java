/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Label;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface LabelFacadeLocal {

    void create(Label label);

    void edit(Label label);

    void remove(Label label);

    Label find(Object id);

    List<Label> findAll();

    List<Label> findRange(int[] range);

    int count();
    
}
