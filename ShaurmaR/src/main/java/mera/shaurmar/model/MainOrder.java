
package mera.shaurmar.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@MappedSuperclass
@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name="dtype")
@SequenceGenerator(name="ord_seq",
        sequenceName="ord_seq", 
        allocationSize=1,initialValue = 1)
public abstract class MainOrder implements Serializable {//TODO classname
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ord_seq")
    @Column(name = "ordid")
    protected long id;
    
    @Enumerated(EnumType.STRING)
    protected Status status = Status.NEW;
    
    @Temporal(TemporalType.TIMESTAMP)
    protected java.util.Date creationDate;
    
    protected String buyer;//todo new class?

    protected String note;//todo new class?
    
    protected Integer price;//TODO price //todo new class?
    
    public MainOrder (){
        System.out.println("jav.Order.<init>()");
    }

    public MainOrder(Date creationDate, String buyer, String note, Integer price, Status status) {
        this.creationDate = creationDate;
        this.buyer = buyer;
        this.note = note;
        this.price = price;
        this.status = status;
    }
 
    
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
}
