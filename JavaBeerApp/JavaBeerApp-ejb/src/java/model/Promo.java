/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thibault
 */
@Entity
@Table(name = "PROMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promo.findAll", query = "SELECT p FROM Promo p"),
    @NamedQuery(name = "Promo.findById", query = "SELECT p FROM Promo p WHERE p.id = :id"),
    @NamedQuery(name = "Promo.findByReduction", query = "SELECT p FROM Promo p WHERE p.reduction = :reduction"),
    @NamedQuery(name = "Promo.findByDatebegin", query = "SELECT p FROM Promo p WHERE p.datebegin = :datebegin"),
    @NamedQuery(name = "Promo.findByDateend", query = "SELECT p FROM Promo p WHERE p.dateend = :dateend"),
    @NamedQuery(name = "Promo.findPromoCurrent", query = "SELECT p FROM Promo p WHERE p.datebegin <= :today AND p.dateend > :today"),
    @NamedQuery(name = "Promo.findByUrlimage", query = "SELECT p FROM Promo p WHERE p.urlimage = :urlimage")})
public class Promo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REDUCTION")
    private int reduction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEBEGIN")
    @Temporal(TemporalType.DATE)
    private Date datebegin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEEND")
    @Temporal(TemporalType.DATE)
    private Date dateend;
    @Size(max = 255)
    @Column(name = "URLIMAGE")
    private String urlimage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promoid")
    private Collection<Translatepromo> translatepromoCollection;
    @JoinColumn(name = "COUNTRYPROMO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Country countrypromo;

    public Promo() {
    }

    public Promo(Integer id) {
        this.id = id;
    }

    public Promo(Integer id, int reduction, Date datebegin, Date dateend) {
        this.id = id;
        this.reduction = reduction;
        this.datebegin = datebegin;
        this.dateend = dateend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public Date getDatebegin() {
        return datebegin;
    }

    public void setDatebegin(Date datebegin) {
        this.datebegin = datebegin;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
        this.dateend = dateend;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    @XmlTransient
    public Collection<Translatepromo> getTranslatepromoCollection() {
        return translatepromoCollection;
    }

    public void setTranslatepromoCollection(Collection<Translatepromo> translatepromoCollection) {
        this.translatepromoCollection = translatepromoCollection;
    }

    public Country getCountrypromo() {
        return countrypromo;
    }

    public void setCountrypromo(Country countrypromo) {
        this.countrypromo = countrypromo;
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
        if (!(object instanceof Promo)) {
            return false;
        }
        Promo other = (Promo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Promo[ id=" + id + " ]";
    }
    
}
