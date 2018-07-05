
package mera.shaurmar.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import mera.shaurmar.model.Ingredient;


public class IngredientDTO {
    //@Null
    public Long id;
    @NotNull
    public String name;
    @NotNull
    public double price;

    public IngredientDTO(Ingredient ing) {
        this.id = ing.getId();
        this.name = ing.getName();
        this.price = ing.getPrice();
    }

    public IngredientDTO() {
    }

    
    @Override
    public String toString() {
        return "IngredientDTO{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
    
}
