/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import java.util.List;
import javax.ejb.Local;
import model.Beershop;

/**
 *
 * @author Thibault
 */
@Local
public interface BeershopFacadeLocal {

    void create(Beershop beershop);

    void edit(Beershop beershop);

    void remove(Beershop beershop);

    Beershop find(Object id);

    List<Beershop> findAll();

    List<Beershop> findRange(int[] range);

    int count();
    
    Beershop findByIdLang(int id, String lang);
    
}
