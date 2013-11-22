/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

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
@Table(name = "COMMENTITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commentitem.findAll", query = "SELECT c FROM Commentitem c"),
    @NamedQuery(name = "Commentitem.findById", query = "SELECT c FROM Commentitem c WHERE c.id = :id"),
    @NamedQuery(name = "Commentitem.findByContent", query = "SELECT c FROM Commentitem c WHERE c.content = :content"),
    @NamedQuery(name = "Commentitem.findByCommentdate", query = "SELECT c FROM Commentitem c WHERE c.commentdate = :commentdate")})
public class Commentitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "CONTENT")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMMENTDATE")
    @Temporal(TemporalType.DATE)
    private Date commentdate;
    @JoinColumn(name = "ITEMID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Item itemid;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Customer customerid;

    public Commentitem() {
    }

    public Commentitem(Integer id) {
        this.id = id;
    }

    public Commentitem(Integer id, String content, Date commentdate) {
        this.id = id;
        this.content = content;
        this.commentdate = commentdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
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
        if (!(object instanceof Commentitem)) {
            return false;
        }
        Commentitem other = (Commentitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Commentitem[ id=" + id + " ]";
    }
    
}
