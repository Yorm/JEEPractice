
package mera.shaurmar.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table(name="CustomOrderMenu_Ingredient")
@IdClass(COMIKey.class)
@CascadeOnDelete
public class CustomOrderMenuIngredient implements Serializable{
    private static final long serialVersionUID = 15L;

    @Id
    private long comtable_id;
    
    @Id
    private long ingredientId;   
    
    private int count;   
    
    @ManyToOne
    @PrimaryKeyJoinColumn (name = "comtable_id" ,  referencedColumnName = "id" ) 
    private CustomOrderMenu com;
    
    @ManyToOne
    @PrimaryKeyJoinColumn (name = "ingredientId" ,  referencedColumnName = "id" ) 
    private Ingredient ing;
    
    public CustomOrderMenuIngredient(){}

    public long getComtable_id() {
        return comtable_id;
    }

    public void setComtable_id(long comtable_id) {
        this.comtable_id = comtable_id;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CustomOrderMenu getCom() {
        return com;
    }

    public void setCom(CustomOrderMenu com) {
        this.com = com;
    }

    public Ingredient getIng() {
        return ing;
    }

    public void setIng(Ingredient ing) {
        this.ing = ing;
    }

    /*@Override
    public String toString() {
        return "CustomOrderMenuIngredient{" + "comtable_id=" + comtable_id + ", ingredientId=" + ingredientId + ", count=" + count + '}';
    }*/

    @Override
    public String toString() {
        return "CustomOrderMenuIngredient{" + "comtable_id=" + comtable_id + ", ingredientId=" + ingredientId + ", count=" + count + /*", com=" + com +*/ ", ing=" + ing + '}';
    }
    

   
    

    

    
}
