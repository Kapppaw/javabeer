/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thibault
 */
@Entity
@Table(name = "ORDERCART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordercart.findAll", query = "SELECT o FROM Ordercart o"),
    @NamedQuery(name = "Ordercart.findById", query = "SELECT o FROM Ordercart o WHERE o.id = :id"),
    @NamedQuery(name = "Ordercart.findByDateorder", query = "SELECT o FROM Ordercart o WHERE o.dateorder = :dateorder")})
public class Ordercart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEORDER")
    @Temporal(TemporalType.DATE)
    private Date dateorder;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordercartid")
    private Collection<Iteminorder> iteminorderCollection;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Customer customerid;

    public Ordercart() {
    }

    public Ordercart(Integer id) {
        this.id = id;
    }

    public Ordercart(Integer id, Date dateorder) {
        this.id = id;
        this.dateorder = dateorder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateorder() {
        return dateorder;
    }

    public void setDateorder(Date dateorder) {
        this.dateorder = dateorder;
    }

    @XmlTransient
    public Collection<Iteminorder> getIteminorderCollection() {
        return iteminorderCollection;
    }

    public void setIteminorderCollection(Collection<Iteminorder> iteminorderCollection) {
        this.iteminorderCollection = iteminorderCollection;
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
        if (!(object instanceof Ordercart)) {
            return false;
        }
        Ordercart other = (Ordercart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Ordercart[ id=" + id + " ]";
    }
    
}
