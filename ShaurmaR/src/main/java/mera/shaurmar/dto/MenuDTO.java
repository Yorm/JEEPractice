
package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.Ingredient;
import mera.shaurmar.model.SimpleOrd_Menu;


public class MenuDTO {
    public Long id;
    public String name;
    public List<IngredientDTO> ingredients = new ArrayList<>();
    private List<SimpleOrd_Menu_DTO> orders = new ArrayList<>();
    
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
            ings.add(new Ingredient(ing.name,ing.price));
        }
        return ings;
    }
    
    public List<SimpleOrd_Menu> getOrders(){
        List<SimpleOrd_Menu> orders = new ArrayList<>();
        /*for(IngredientDTO ing : ingredients){
            ings.add(new Ingredient(ing.name,ing.price));
        }*/
        return orders;
    }
}
