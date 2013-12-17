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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thibault
 */
@Entity
@Table(name = "ITEMINORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iteminorder.findAll", query = "SELECT i FROM Iteminorder i"),
    @NamedQuery(name = "Iteminorder.findById", query = "SELECT i FROM Iteminorder i WHERE i.id = :id"),
    @NamedQuery(name = "Iteminorder.findByQuantity", query = "SELECT i FROM Iteminorder i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "Iteminorder.findByPrice", query = "SELECT i FROM Iteminorder i WHERE i.price = :price")})
public class Iteminorder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;
    @Min(value=1)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @JoinColumn(name = "ORDERCARTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ordercart ordercartid;
    @JoinColumn(name = "ITEMID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item itemid;

    public Iteminorder() {
    }

    public Iteminorder(Integer id) {
        this.id = id;
    }

    public Iteminorder(Integer id, int quantity, double price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
    
    public Iteminorder(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
    
    public Iteminorder(int quantity, double price, Item item) {
        this.quantity = quantity;
        this.price = price;
        this.itemid = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Ordercart getOrdercartid() {
        return ordercartid;
    }

    public void setOrdercartid(Ordercart ordercartid) {
        this.ordercartid = ordercartid;
    }

    public Item getItemid() {
        return itemid;
    }

    public void setItemid(Item itemid) {
        this.itemid = itemid;
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
        if (!(object instanceof Iteminorder)) {
            return false;
        }
        Iteminorder other = (Iteminorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Iteminorder[ id=" + id + " ]";
    }
    
}
