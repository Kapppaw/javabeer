/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Translatepromo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface TranslatepromoFacadeLocal {

    void create(Translatepromo translatepromo);

    void edit(Translatepromo translatepromo);

    void remove(Translatepromo translatepromo);

    Translatepromo find(Object id);

    List<Translatepromo> findAll();

    List<Translatepromo> findRange(int[] range);

    int count();
    
    List<Translatepromo> findCurrentLang(String lang);
    
}
