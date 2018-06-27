
package mera.shaurmar.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CustomOrderMenu_Ingredient")
@IdClass(COMI_Key.class)
public class CustomOrderMenu_Ingredient implements Serializable{
    private static final long serialVersionUID = 15L;

    @Id
    private long comtable_id;
    
    @Id
    private long ingredientId;   
    
    private int count;   
    
    public CustomOrderMenu_Ingredient(){}
    
    @ManyToOne
    @PrimaryKeyJoinColumn (name = "comtable_id" ,  referencedColumnName = "id" ) 
    private CustomOrder_Menu com;
    
    @ManyToOne/*(cascade={CascadeType.PERSIST})*/
    @PrimaryKeyJoinColumn (name = "ingredientId" ,  referencedColumnName = "id" ) 
    private Ingredient ing;

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

    public CustomOrder_Menu getCom() {
        return com;
    }

    public void setCom(CustomOrder_Menu com) {
        this.com = com;
    }

    public Ingredient getIng() {
        return ing;
    }

    public void setIng(Ingredient ing) {
        this.ing = ing;
    }

}
