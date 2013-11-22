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
@Table(name = "TRANSLATECOUNTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Translatecountry.findAll", query = "SELECT t FROM Translatecountry t"),
    @NamedQuery(name = "Translatecountry.findById", query = "SELECT t FROM Translatecountry t WHERE t.id = :id"),
    @NamedQuery(name = "Translatecountry.findByCountryname", query = "SELECT t FROM Translatecountry t WHERE t.countryname = :countryname")})
public class Translatecountry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COUNTRYNAME")
    private String countryname;
    @JoinColumn(name = "LANGUAGEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Languagetranslate languageid;
    @JoinColumn(name = "COUNTRYID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Country countryid;

    public Translatecountry() {
    }

    public Translatecountry(Integer id) {
        this.id = id;
    }

    public Translatecountry(Integer id, String countryname) {
        this.id = id;
        this.countryname = countryname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public Languagetranslate getLanguageid() {
        return languageid;
    }

    public void setLanguageid(Languagetranslate languageid) {
        this.languageid = languageid;
    }

    public Country getCountryid() {
        return countryid;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
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
        if (!(object instanceof Translatecountry)) {
            return false;
        }
        Translatecountry other = (Translatecountry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Translatecountry[ id=" + id + " ]";
    }
    
}
