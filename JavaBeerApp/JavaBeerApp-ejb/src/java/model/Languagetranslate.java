/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thibault
 */
@Entity
@Table(name = "LANGUAGETRANSLATE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Languagetranslate.findAll", query = "SELECT l FROM Languagetranslate l"),
    @NamedQuery(name = "Languagetranslate.findById", query = "SELECT l FROM Languagetranslate l WHERE l.id = :id"),
    @NamedQuery(name = "Languagetranslate.findByName", query = "SELECT l FROM Languagetranslate l WHERE l.name = :name")})
public class Languagetranslate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageid")
    private Collection<Translatecategory> translatecategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageid")
    private Collection<Translatepromo> translatepromoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageid")
    private Collection<Translatecountry> translatecountryCollection;

    public Languagetranslate() {
    }

    public Languagetranslate(Integer id) {
        this.id = id;
    }

    public Languagetranslate(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Translatecategory> getTranslatecategoryCollection() {
        return translatecategoryCollection;
    }

    public void setTranslatecategoryCollection(Collection<Translatecategory> translatecategoryCollection) {
        this.translatecategoryCollection = translatecategoryCollection;
    }

    @XmlTransient
    public Collection<Translatepromo> getTranslatepromoCollection() {
        return translatepromoCollection;
    }

    public void setTranslatepromoCollection(Collection<Translatepromo> translatepromoCollection) {
        this.translatepromoCollection = translatepromoCollection;
    }

    @XmlTransient
    public Collection<Translatecountry> getTranslatecountryCollection() {
        return translatecountryCollection;
    }

    public void setTranslatecountryCollection(Collection<Translatecountry> translatecountryCollection) {
        this.translatecountryCollection = translatecountryCollection;
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
        if (!(object instanceof Languagetranslate)) {
            return false;
        }
        Languagetranslate other = (Languagetranslate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Languagetranslate[ id=" + id + " ]";
    }
    
}
