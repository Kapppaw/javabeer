/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thibault
 */
@Entity
@Table(name = "TRANSLATEITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Translateitem.findOne", query = "SELECT DISTINCT(t) FROM Translateitem t, Item i, Languagetranslate la, Category c, Categoryoftheitem ci, Translatecategory tc, Translatecountry tco, Country co WHERE t.itemid.id = i.id AND t.languageid.id = la.id AND co.id = tco.countryid.id AND i.origin.id = co.id AND tco.languageid.id = la.id AND tc.languageid.id = la.id  AND tc.categoryid.id = c.id  AND ci.categoryid.id = c.id AND i.id = ci.itemid.id AND la.name = :lang AND i.id = :id"),
    @NamedQuery(name = "Translateitem.findLast", query = "SELECT DISTINCT(t) FROM Translateitem t, Item i, Languagetranslate l WHERE t.itemid.id = i.id AND l.id = t.languageid.id AND L.name = :lang ORDER BY i.datearrived DESC"),
    @NamedQuery(name = "Translateitem.searchItem", query = "SELECT DISTINCT(t) FROM Item i, Country c, Languagetranslate l, Translatecountry ti, Translateitem t WHERE t.itemid.id = i.id AND t.languageid.id = l.id AND i.origin.id = c.id AND l.id = ti.languageid.id AND ti.countryid.id = c.id AND i.name = :name AND l.name = :lang"),
    @NamedQuery(name = "Translateitem.findCurrentPromoLang", query = "SELECT t from Translateitem t, Promo p, Languagetranslate l, Country c, Item i, Translatepromo tp WHERE tp.languageid.id = l.id AND tp.promoid.id = p.id AND p.countrypromo.id = c.id AND i.origin.id = c.id AND t.itemid.id = i.id AND t.languageid.id = l.id AND l.name = :lang AND p.datebegin <= CURRENT_DATE AND p.dateend >= CURRENT_DATE"),
    @NamedQuery(name = "Translateitem.findByAll", query = "SELECT t FROM Translateitem t"),
    @NamedQuery(name = "Translateitem.findByItemdesc", query = "SELECT t FROM Translateitem t WHERE t.itemdesc = :itemdesc")})
public class Translateitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "ITEMDESC")
    private String itemdesc;
    @JoinColumn(name = "LANGUAGEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Languagetranslate languageid;
    @JoinColumn(name = "ITEMID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item itemid;
    
    
    public Translateitem() {
    }

    public Translateitem(Integer id) {
        this.id = id;
    }

    public Translateitem(Integer id, String itemdesc) {
        this.id = id;
        this.itemdesc = itemdesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Translateitem)) {
            return false;
        }
        Translateitem other = (Translateitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Translateitem[ id=" + id + " ]";
    }

    /**
     * @return the languageid
     */
    public Languagetranslate getLanguageid() {
        return languageid;
    }

    /**
     * @param languageid the languageid to set
     */
    public void setLanguageid(Languagetranslate languageid) {
        this.languageid = languageid;
    }

    /**
     * @return the itemid
     */
    public Item getItemid() {
        return itemid;
    }

    /**
     * @param itemid the itemid to set
     */
    public void setItemid(Item itemid) {
        this.itemid = itemid;
    }
    
}
