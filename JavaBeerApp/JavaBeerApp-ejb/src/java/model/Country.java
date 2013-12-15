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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thibault
 */
@Entity
@Table(name = "COUNTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @NamedQuery(name = "Country.findById", query = "SELECT  c FROM Country c WHERE c.id = :id")})
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addresscountry")
    private Collection<Customer> customerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origin")
    private Collection<Item> itemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countrypromo")
    private Collection<Promo> promoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addresscountry")
    private Collection<Beershop> beershopCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryid")
    private Collection<Translatecountry> translatecountryCollection;

    public Country() {
    }

    public Country(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @XmlTransient
    public Collection<Promo> getPromoCollection() {
        return promoCollection;
    }

    public void setPromoCollection(Collection<Promo> promoCollection) {
        this.promoCollection = promoCollection;
    }

    @XmlTransient
    public Collection<Beershop> getBeershopCollection() {
        return beershopCollection;
    }

    public void setBeershopCollection(Collection<Beershop> beershopCollection) {
        this.beershopCollection = beershopCollection;
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
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Country[ id=" + id + " ]";
    }
    
}
