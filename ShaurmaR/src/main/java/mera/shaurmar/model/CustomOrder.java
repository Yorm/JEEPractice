package mera.shaurmar.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@DiscriminatorValue(value="simple")
@SequenceGenerator(name="ord_seq",
        sequenceName="ord_seq", 
        allocationSize=1,initialValue = 1)
public class CustomOrder  implements Serializable{
    private static final long serialVersionUID = 3L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ord_seq")
    private long id;
    
    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime creationDate;
    
    //@Column(nullable = false)
    //@NotNull
    private String buyer;

    private String note;
    
    //@Column(nullable = false)
    //@NotNull
    private double sum;
    
    @OneToMany(mappedBy="cusorder",fetch = FetchType.EAGER/*, cascade = CascadeType.REMOVE, orphanRemoval = true*/)
    private List<CustomOrderMenu> menu  = new ArrayList<>();
    
    
    public CustomOrder(){
    }
    
    public CustomOrder(ZonedDateTime creationDate, String buyer, String note, double sum, Status status) {
        this.creationDate = creationDate;
        this.buyer = buyer;
        this.note = note;
        this.sum = sum;
        this.status = status;
    }

    public List<CustomOrderMenu> getMenu() {
        return menu;
    }

    public void setMenu(List<CustomOrderMenu> menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.status);
        hash = 37 * hash + Objects.hashCode(this.creationDate);
        hash = 37 * hash + Objects.hashCode(this.buyer);
        hash = 37 * hash + Objects.hashCode(this.note);
        hash = 37 * hash + Objects.hashCode(this.sum);
        hash = 37 * hash + Objects.hashCode(this.menu);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CustomOrder other = (CustomOrder) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.buyer, other.buyer)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.creationDate, other.creationDate)) {
            return false;
        }
        if (!Objects.equals(this.sum, other.sum)) {
            return false;
        }
        if (!Objects.equals(this.menu, other.menu)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomOrder{" + "id=" + id + ", status=" + status + ", creationDate=" + creationDate + ", buyer=" + buyer + ", note=" + note + ", sum=" + sum + ", menu=" + menu + '}';
    }



    
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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
