package mera.shaurmar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class CompoundOrd extends Order implements Serializable{
    
    @ManyToMany
    private Set<Ingredient> compoundSh = new HashSet<>();
    
    public CompoundOrd(){
        System.out.println("jav.CompoundOrd.<init>()");
    }
    
    public CompoundOrd(Date creationDate, String buyer, String note, Integer sum, Status status) {
        this.creationDate = creationDate;
        this.buyer = buyer;
        this.note = note;
        this.sum = sum;
        this.status = status;
    }

    public Set<Ingredient> getCompoundSh() {
        return compoundSh;
    }

    public void setCompoundSh(Set<Ingredient> compoundSh) {
        this.compoundSh = compoundSh;
    }
    
}
