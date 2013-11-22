/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import model.Languagetranslate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface LanguagetranslateFacadeLocal {

    void create(Languagetranslate languagetranslate);

    void edit(Languagetranslate languagetranslate);

    void remove(Languagetranslate languagetranslate);

    Languagetranslate find(Object id);

    List<Languagetranslate> findAll();

    List<Languagetranslate> findRange(int[] range);

    int count();
    
}
