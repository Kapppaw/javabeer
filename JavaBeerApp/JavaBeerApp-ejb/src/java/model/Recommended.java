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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thibault
 */
@Entity
@Table(name = "RECOMMENDED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recommended.findAll", query = "SELECT r FROM Recommended r  WHERE r.dateend >= CURRENT_DATE AND r.datebegin <= CURRENT_DATE"),
    @NamedQuery(name = "Recommended.findById", query = "SELECT r FROM Recommended r WHERE r.id = :id"),
    @NamedQuery(name = "Recommended.findByDatebegin", query = "SELECT r FROM Recommended r WHERE r.datebegin = :datebegin"),
    @NamedQuery(name = "Recommended.findByDateend", query = "SELECT r FROM Recommended r WHERE r.dateend = :dateend")})
public class Recommended implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
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
    @JoinColumn(name = "ITEMID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item itemid;

    public Recommended() {
    }

    public Recommended(Integer id) {
        this.id = id;
    }

    public Recommended(Integer id, Date datebegin, Date dateend) {
        this.id = id;
        this.datebegin = datebegin;
        this.dateend = dateend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Recommended)) {
            return false;
        }
        Recommended other = (Recommended) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Recommended[ id=" + id + " ]";
    }
    
}
