/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Translatecategory;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface TranslatecategoryFacadeLocal {

    void create(Translatecategory translatecategory);

    void edit(Translatecategory translatecategory);

    void remove(Translatecategory translatecategory);

    Translatecategory find(Object id);

    List<Translatecategory> findAll();

    List<Translatecategory> findRange(int[] range);

    int count();
    
}
