package mera.shaurmar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="compound")
public class CompoundOrd extends MainOrder implements Serializable{

    @OneToMany(mappedBy="compoundord")
    private List<CompoundOrd_Ingredient> ingredients = new ArrayList<>();;
    
    public CompoundOrd(){
    }
    
    public CompoundOrd(Date creationDate, String buyer, String note, Integer price, Status status) {
        this.creationDate = creationDate;
        this.buyer = buyer;
        this.note = note;
        this.price = price;
        this.status = status;
    }

    public List<CompoundOrd_Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<CompoundOrd_Ingredient> ingredients) {
        this.ingredients = ingredients;
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
        return price;
    }

    public void setSum(Integer sum) {
        this.price = sum;
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
