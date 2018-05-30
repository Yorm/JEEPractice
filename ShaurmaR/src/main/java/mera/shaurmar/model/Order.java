
package mera.shaurmar.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@MappedSuperclass
@SequenceGenerator(name="ord_seq",sequenceName="ord_seq", allocationSize=1,initialValue = 1)
public abstract class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ord_seq")
    @Column(name = "ordid")
    protected long id;
    
    @Enumerated(EnumType.STRING)
    protected Status status = Status.NEW;
    
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    protected java.util.Date creationDate;
    
    protected String buyer;

    protected String note;
    
    protected Integer sum;
    
    public Order (){
        System.out.println("jav.Order.<init>()");
    }

    public Order(Date creationDate, String buyer, String note, Integer sum, Status status) {
        this.creationDate = creationDate;
        this.buyer = buyer;
        this.note = note;
        this.sum = sum;
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
    
    
}
