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
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.connect", query = "SELECT c FROM Customer c WHERE c.login = :login AND c.password = :password"),
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id"),
    @NamedQuery(name = "Customer.findByLogin", query = "SELECT c FROM Customer c WHERE c.login = :login"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name"),
    @NamedQuery(name = "Customer.findByFirstname", query = "SELECT c FROM Customer c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email"),
    @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customer.findByAddressnumber", query = "SELECT c FROM Customer c WHERE c.addressnumber = :addressnumber"),
    @NamedQuery(name = "Customer.findByAddressstreet", query = "SELECT c FROM Customer c WHERE c.addressstreet = :addressstreet"),
    @NamedQuery(name = "Customer.findByAddresscity", query = "SELECT c FROM Customer c WHERE c.addresscity = :addresscity"),
    @NamedQuery(name = "Customer.findByAddresszipcode", query = "SELECT c FROM Customer c WHERE c.addresszipcode = :addresszipcode"),
    @NamedQuery(name = "Customer.findByAddressregion", query = "SELECT c FROM Customer c WHERE c.addressregion = :addressregion"),
    @NamedQuery(name = "Customer.findByAddressprovince", query = "SELECT c FROM Customer c WHERE c.addressprovince = :addressprovince")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FIRSTNAME")
    private String firstname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PHONE")
    private String phone;
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
    @Size(max = 255)
    @Column(name = "ADDRESSREGION")
    private String addressregion;
    @Size(max = 255)
    @Column(name = "ADDRESSPROVINCE")
    private String addressprovince;
    @JoinColumn(name = "ADDRESSCOUNTRY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Country addresscountry;
    

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(Integer id, String login, String password, String name, String firstname, String email, String phone, int addressnumber, String addressstreet, String addresscity, int addresszipcode) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.addressnumber = addressnumber;
        this.addressstreet = addressstreet;
        this.addresscity = addresscity;
        this.addresszipcode = addresszipcode;
    }

    
    public Customer(String login, String password, String name, String firstname, String email, String phone, int addressnumber, String addressstreet, String addresscity, int addresszipcode, int addcountry) {       
        this.login = login;
        this.password = password;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.addressnumber = addressnumber;
        this.addressstreet = addressstreet;
        this.addresscity = addresscity;
        this.addresszipcode = addresszipcode;
        this.addresscountry = new Country(addcountry);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getAddressregion() {
        return addressregion;
    }

    public void setAddressregion(String addressregion) {
        this.addressregion = addressregion;
    }

    public String getAddressprovince() {
        return addressprovince;
    }

    public void setAddressprovince(String addressprovince) {
        this.addressprovince = addressprovince;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Customer[ id=" + id + " ]";
    }
    
}
