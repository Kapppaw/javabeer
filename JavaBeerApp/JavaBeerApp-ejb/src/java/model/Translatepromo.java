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
@Table(name = "TRANSLATEPROMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Translatepromo.findAll", query = "SELECT t FROM Translatepromo t"),
    @NamedQuery(name = "Translatepromo.findById", query = "SELECT t FROM Translatepromo t WHERE t.id = :id"),
    @NamedQuery(name = "Translatepromo.findByPromoname", query = "SELECT t FROM Translatepromo t WHERE t.promoname = :promoname")})
public class Translatepromo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PROMONAME")
    private String promoname;
    @JoinColumn(name = "PROMOID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Promo promoid;
    @JoinColumn(name = "LANGUAGEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Languagetranslate languageid;

    public Translatepromo() {
    }

    public Translatepromo(Integer id) {
        this.id = id;
    }

    public Translatepromo(Integer id, String promoname) {
        this.id = id;
        this.promoname = promoname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPromoname() {
        return promoname;
    }

    public void setPromoname(String promoname) {
        this.promoname = promoname;
    }

    public Promo getPromoid() {
        return promoid;
    }

    public void setPromoid(Promo promoid) {
        this.promoid = promoid;
    }

    public Languagetranslate getLanguageid() {
        return languageid;
    }

    public void setLanguageid(Languagetranslate languageid) {
        this.languageid = languageid;
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
        if (!(object instanceof Translatepromo)) {
            return false;
        }
        Translatepromo other = (Translatepromo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Translatepromo[ id=" + id + " ]";
    }
    
}
