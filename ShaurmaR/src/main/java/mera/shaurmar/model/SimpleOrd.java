package mera.shaurmar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@DiscriminatorValue(value="simple")
public class SimpleOrd extends MainOrder implements Serializable{
    private static final long serialVersionUID = 3L;
    
    @OneToMany(mappedBy="simpleord")
    private List<SimpleOrd_Menu> menuSh = new ArrayList<>();;
    
    public SimpleOrd(){
    }
    
    public SimpleOrd(Date creationDate, String buyer, String note, Integer price, Status status, List<SimpleOrd_Menu> menuSh) {
        this.creationDate = creationDate;
        this.buyer = buyer;
        this.note = note;
        this.price = price;
        this.status = status;
        this.menuSh = menuSh;
    }

    public List<SimpleOrd_Menu> getMenuSh() {
        return menuSh;
    }

    public void setMenuSh(List<SimpleOrd_Menu> menuSh) {
        this.menuSh = menuSh;
    }
    
    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String getBuyer() {
        return buyer;
    }

    @Override
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

}
