/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thibault
 */
@Entity
@Table(name = "RANKITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rankitem.findAll", query = "SELECT r FROM Rankitem r"),
    @NamedQuery(name = "Rankitem.findById", query = "SELECT r FROM Rankitem r WHERE r.id = :id"),
    @NamedQuery(name = "Rankitem.findByItemrank", query = "SELECT r FROM Rankitem r WHERE r.itemrank = :itemrank")})
public class Rankitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEMRANK")
    private int itemrank;
    @JoinColumn(name = "ITEMID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item itemid;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Customer customerid;

    public Rankitem() {
    }

    public Rankitem(Integer id) {
        this.id = id;
    }

    public Rankitem(Integer id, int itemrank) {
        this.id = id;
        this.itemrank = itemrank;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getItemrank() {
        return itemrank;
    }

    public void setItemrank(int itemrank) {
        this.itemrank = itemrank;
    }

    public Item getItemid() {
        return itemid;
    }

    public void setItemid(Item itemid) {
        this.itemid = itemid;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
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
        if (!(object instanceof Rankitem)) {
            return false;
        }
        Rankitem other = (Rankitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Rankitem[ id=" + id + " ]";
    }
    
}
