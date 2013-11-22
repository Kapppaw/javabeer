/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBean;

import data.Newsletter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Thibault
 */
@Local
public interface NewsletterFacadeLocal {

    void create(Newsletter newsletter);

    void edit(Newsletter newsletter);

    void remove(Newsletter newsletter);

    Newsletter find(Object id);

    List<Newsletter> findAll();

    List<Newsletter> findRange(int[] range);

    int count();
    
}
