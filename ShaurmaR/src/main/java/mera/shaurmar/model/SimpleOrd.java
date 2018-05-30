package mera.shaurmar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class SimpleOrd extends Order implements Serializable{
    
    @ManyToMany
    private Set<Menu> menuSh = new HashSet<>();
    
    public SimpleOrd(){
        System.out.println("jav.SimpleOrd.<init>()");
    }

    public SimpleOrd(Date creationDate, String buyer, String note, Integer sum, Status status, Set<Menu> menuSh) {
        this.creationDate = creationDate;
        this.buyer = buyer;
        this.note = note;
        this.sum = sum;
        this.status = status;
        this.menuSh = menuSh;
    }

    public Set<Menu> getMenu() {
        return menuSh;
    }

    public void setMenu(Set<Menu> menuSh) {
        this.menuSh = menuSh;
    }

    
    
}
