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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thibault
 */
@Entity
@Table(name = "ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findBestSales", query = "SELECT  DISTINCT(i)  FROM Item i, Category c, Categoryoftheitem ci WHERE i.id = ci.itemid.id AND ci.categoryid.id = c.id ORDER BY i.quantitysale DESC "),
    @NamedQuery(name = "Item.findByCat", query = "SELECT i FROM Item i, Category c, Categoryoftheitem ci WHERE i.id = ci.itemid.id AND ci.categoryid.id = c.id AND c.id = :idCat"),
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findByDatearrived", query = "SELECT i FROM Item i WHERE i.datearrived = :datearrived"),
    @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price"),
    @NamedQuery(name = "Item.findByCapacity", query = "SELECT i FROM Item i WHERE i.capacity = :capacity"),
    @NamedQuery(name = "Item.findByDegalcohol", query = "SELECT i FROM Item i WHERE i.degalcohol = :degalcohol"),
    @NamedQuery(name = "Item.findByUrlimage", query = "SELECT i FROM Item i WHERE i.urlimage = :urlimage"),
    @NamedQuery(name = "Item.findByQuantitysale", query = "SELECT i FROM Item i WHERE i.quantitysale = :quantitysale")})
public class Item implements Serializable {
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
    @Column(name = "DATEARRIVED")
    @Temporal(TemporalType.DATE)
    private Date datearrived;
    @Min(value=0)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACITY")
    private int capacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEGALCOHOL")
    private double degalcohol;
    @Size(max = 255)
    @Column(name = "URLIMAGE")
    private String urlimage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITYSALE")
    private int quantitysale;
    @JoinColumn(name = "LABELID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Label labelid;
    @JoinColumn(name = "ORIGIN", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Country origin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemid")
    private Collection<Categoryoftheitem> categoryoftheitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemid")
    private Collection<Iteminorder> iteminorderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemid")
    private Collection<Recommended> recommendedCollection;
    
    //private boolean promo;


    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, String name, Date datearrived, double price, int capacity, double degalcohol, int quantitysale) {
        this.id = id;
        this.name = name;
        this.datearrived = datearrived;
        this.price = price;
        this.capacity = capacity;
        this.degalcohol = degalcohol;
        this.quantitysale = quantitysale;
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

    public Date getDatearrived() {
        return datearrived;
    }

    public void setDatearrived(Date datearrived) {
        this.datearrived = datearrived;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getDegalcohol() {
        return degalcohol;
    }

    public void setDegalcohol(double degalcohol) {
        this.degalcohol = degalcohol;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    public int getQuantitysale() {
        return quantitysale;
    }

    public void setQuantitysale(int quantitysale) {
        this.quantitysale = quantitysale;
    }

    public Label getLabelid() {
        return labelid;
    }

    public void setLabelid(Label labelid) {
        this.labelid = labelid;
    }

    public Country getOrigin() {
        return origin;
    }

    public void setOrigin(Country origin) {
        this.origin = origin;
    }

    @XmlTransient
    public Collection<Categoryoftheitem> getCategoryoftheitemCollection() {
        return categoryoftheitemCollection;
    }

    public void setCategoryoftheitemCollection(Collection<Categoryoftheitem> categoryoftheitemCollection) {
        this.categoryoftheitemCollection = categoryoftheitemCollection;
    }

    @XmlTransient
    public Collection<Iteminorder> getIteminorderCollection() {
        return iteminorderCollection;
    }

    public void setIteminorderCollection(Collection<Iteminorder> iteminorderCollection) {
        this.iteminorderCollection = iteminorderCollection;
    }

    @XmlTransient
    public Collection<Recommended> getRecommendedCollection() {
        return recommendedCollection;
    }

    public void setRecommendedCollection(Collection<Recommended> recommendedCollection) {
        this.recommendedCollection = recommendedCollection;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Item[ id=" + id + " ]";
    }

    /**
     * @return the promo
     */
    /*public boolean isPromo() {
        return promo;
    }
*/
    /**
     * @param promo the promo to set
     */
    /*public void setPromo(boolean promo) {
        this.promo = promo;
    }*/
    
}
