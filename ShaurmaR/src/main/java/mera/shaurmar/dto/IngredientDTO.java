
package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.Menu;


public class IngredientDTO {
    public Long id;
    public String name;
    public Float price;

    @Override
    public String toString() {
        return "IngredientDTO{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
    
}
