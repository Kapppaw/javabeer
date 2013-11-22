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
@Table(name = "TRANSLATECATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Translatecategory.findAll", query = "SELECT t FROM Translatecategory t"),
    @NamedQuery(name = "Translatecategory.findById", query = "SELECT t FROM Translatecategory t WHERE t.id = :id"),
    @NamedQuery(name = "Translatecategory.findByColourname", query = "SELECT t FROM Translatecategory t WHERE t.colourname = :colourname"),
    @NamedQuery(name = "Translatecategory.findByColourdesc", query = "SELECT t FROM Translatecategory t WHERE t.colourdesc = :colourdesc")})
public class Translatecategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COLOURNAME")
    private String colourname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COLOURDESC")
    private String colourdesc;
    @JoinColumn(name = "LANGUAGEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Languagetranslate languageid;
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Category categoryid;

    public Translatecategory() {
    }

    public Translatecategory(Integer id) {
        this.id = id;
    }

    public Translatecategory(Integer id, String colourname, String colourdesc) {
        this.id = id;
        this.colourname = colourname;
        this.colourdesc = colourdesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColourname() {
        return colourname;
    }

    public void setColourname(String colourname) {
        this.colourname = colourname;
    }

    public String getColourdesc() {
        return colourdesc;
    }

    public void setColourdesc(String colourdesc) {
        this.colourdesc = colourdesc;
    }

    public Languagetranslate getLanguageid() {
        return languageid;
    }

    public void setLanguageid(Languagetranslate languageid) {
        this.languageid = languageid;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
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
        if (!(object instanceof Translatecategory)) {
            return false;
        }
        Translatecategory other = (Translatecategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Translatecategory[ id=" + id + " ]";
    }
    
}
