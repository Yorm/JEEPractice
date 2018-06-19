
package mera.shaurmar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="compoundord_ingredient")
@IdClass(COI_Key.class)
public class CompoundOrd_Ingredient implements Serializable {
    @Id
    private Long ingredientId;
    @Id
    private Long compoundordId;
    
    @Column(name="count")
    private Integer count;
    
    public CompoundOrd_Ingredient(){}
    
    @ManyToOne
    @PrimaryKeyJoinColumn ( name = "ingredientId" ,  referencedColumnName = "ingid" ) 
    //@JoinColumn (name = "ingredientId", updatable = false, insertable = false, referencedColumnName = "id") 
    private Ingredient ing;
    
    @ManyToOne
    @PrimaryKeyJoinColumn ( name = "compoundordId" ,  referencedColumnName = "ordid" ) 
    //@JoinColumn (name = "compoundordId", updatable = false, insertable = false, referencedColumnName = "id") 
    private CompoundOrd compoundord;

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public long getCompoundordId() {
        return compoundordId;
    }

    public void setCompoundordId(long compoundordId) {
        this.compoundordId = compoundordId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Ingredient getIngredient() {
        return ing;
    }

    public void setIngredient(Ingredient ing) {
        this.ing = ing;
    }

    public CompoundOrd getCompoundord() {
        return compoundord;
    }

    public void setCompoundord(CompoundOrd compoundord) {
        this.compoundord = compoundord;
    }
    
}
