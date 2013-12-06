/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thibault
 */
@Entity
@Table(name = "BEERSHOP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beershop.findAll", query = "SELECT b FROM Beershop b"),
    @NamedQuery(name = "Beershop.findById", query = "SELECT b FROM Beershop b WHERE b.id = :id"),
    @NamedQuery(name = "Beershop.findByIdLang", query = "SELECT b FROM Beershop b, Country c, Languagetranslate lt, Translatecountry tc WHERE b.id = :id AND b.addresscountry.id = c.id AND lt.id = tc.languageid.id AND c.id = tc.countryid.id AND lt.name = :lang"),
    @NamedQuery(name = "Beershop.findByName", query = "SELECT b FROM Beershop b WHERE b.name = :name"),
    @NamedQuery(name = "Beershop.findByDateparam", query = "SELECT b FROM Beershop b WHERE b.dateparam = :dateparam"),
    @NamedQuery(name = "Beershop.findByAddressnumber", query = "SELECT b FROM Beershop b WHERE b.addressnumber = :addressnumber"),
    @NamedQuery(name = "Beershop.findByAddressstreet", query = "SELECT b FROM Beershop b WHERE b.addressstreet = :addressstreet"),
    @NamedQuery(name = "Beershop.findByAddresscity", query = "SELECT b FROM Beershop b WHERE b.addresscity = :addresscity"),
    @NamedQuery(name = "Beershop.findByAddresszipcode", query = "SELECT b FROM Beershop b WHERE b.addresszipcode = :addresszipcode"),
    @NamedQuery(name = "Beershop.findByPhone", query = "SELECT b FROM Beershop b WHERE b.phone = :phone"),
    @NamedQuery(name = "Beershop.findByEmail", query = "SELECT b FROM Beershop b WHERE b.email = :email"),
    @NamedQuery(name = "Beershop.findByNumcptcustomer", query = "SELECT b FROM Beershop b WHERE b.numcptcustomer = :numcptcustomer"),
    @NamedQuery(name = "Beershop.findByDeliveryamount", query = "SELECT b FROM Beershop b WHERE b.deliveryamount = :deliveryamount"),
    @NamedQuery(name = "Beershop.findByDeliverymin", query = "SELECT b FROM Beershop b WHERE b.deliverymin = :deliverymin")})
public class Beershop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEPARAM")
    @Temporal(TemporalType.DATE)
    private Date dateparam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDRESSNUMBER")
    private int addressnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ADDRESSSTREET")
    private String addressstreet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ADDRESSCITY")
    private String addresscity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDRESSZIPCODE")
    private int addresszipcode;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PHONE")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMCPTCUSTOMER")
    private int numcptcustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYAMOUNT")
    private int deliveryamount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERYMIN")
    private int deliverymin;
    @JoinColumn(name = "ADDRESSCOUNTRY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Country addresscountry;

    public Beershop() {
    }

    public Beershop(Integer id) {
        this.id = id;
    }

    public Beershop(Integer id, String name, Date dateparam, int addressnumber, String addressstreet, String addresscity, int addresszipcode, String phone, String email, int numcptcustomer, int deliveryamount, int deliverymin) {
        this.id = id;
        this.name = name;
        this.dateparam = dateparam;
        this.addressnumber = addressnumber;
        this.addressstreet = addressstreet;
        this.addresscity = addresscity;
        this.addresszipcode = addresszipcode;
        this.phone = phone;
        this.email = email;
        this.numcptcustomer = numcptcustomer;
        this.deliveryamount = deliveryamount;
        this.deliverymin = deliverymin;
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

    public Date getDateparam() {
        return dateparam;
    }

    public void setDateparam(Date dateparam) {
        this.dateparam = dateparam;
    }

    public int getAddressnumber() {
        return addressnumber;
    }

    public void setAddressnumber(int addressnumber) {
        this.addressnumber = addressnumber;
    }

    public String getAddressstreet() {
        return addressstreet;
    }

    public void setAddressstreet(String addressstreet) {
        this.addressstreet = addressstreet;
    }

    public String getAddresscity() {
        return addresscity;
    }

    public void setAddresscity(String addresscity) {
        this.addresscity = addresscity;
    }

    public int getAddresszipcode() {
        return addresszipcode;
    }

    public void setAddresszipcode(int addresszipcode) {
        this.addresszipcode = addresszipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumcptcustomer() {
        return numcptcustomer;
    }

    public void setNumcptcustomer(int numcptcustomer) {
        this.numcptcustomer = numcptcustomer;
    }

    public int getDeliveryamount() {
        return deliveryamount;
    }

    public void setDeliveryamount(int deliveryamount) {
        this.deliveryamount = deliveryamount;
    }

    public int getDeliverymin() {
        return deliverymin;
    }

    public void setDeliverymin(int deliverymin) {
        this.deliverymin = deliverymin;
    }

    public Country getAddresscountry() {
        return addresscountry;
    }

    public void setAddresscountry(Country addresscountry) {
        this.addresscountry = addresscountry;
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
        if (!(object instanceof Beershop)) {
            return false;
        }
        Beershop other = (Beershop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Beershop[ id=" + id + " ]";
    }
    
}
