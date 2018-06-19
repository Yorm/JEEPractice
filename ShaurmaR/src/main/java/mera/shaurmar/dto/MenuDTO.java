
package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.Ingredient;


public class MenuDTO {
    public String name;
    public List<IngredientDTO> ingredients = new ArrayList<>();
    
    public float getPrice(){
        float price = 0;
        for(IngredientDTO ing : ingredients){
            price+=ing.price;
        }
        return price;
    }
    
    public List<Ingredient> getIngredient(){
        List<Ingredient> ings = new ArrayList<>();
        for(IngredientDTO ing : ingredients){
            Ingredient i = new Ingredient();
            ings.add(new Ingredient(ing.name,ing.price));
        }
        return ings;
    }
}
