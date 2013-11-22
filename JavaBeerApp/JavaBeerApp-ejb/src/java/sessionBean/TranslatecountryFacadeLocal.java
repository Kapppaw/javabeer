/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import data.Translatecountry;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface TranslatecountryFacadeLocal {

    void create(Translatecountry translatecountry);

    void edit(Translatecountry translatecountry);

    void remove(Translatecountry translatecountry);

    Translatecountry find(Object id);

    List<Translatecountry> findAll();

    List<Translatecountry> findRange(int[] range);

    int count();
    
}
