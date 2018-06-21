
package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.CompoundOrd_Ingredient;
import mera.shaurmar.model.Menu;


public class IngredientDTO {
    public Long id;
    public String name;
    public Float price;
    public List<MenuDTO> menu  = new ArrayList<>();
    public List<CompoundOrd_Ingredient_DTO> shaurma = new ArrayList<>();
    
    public List<Menu> getMenu(){
        List<Menu> menu = new ArrayList<>();
        for(MenuDTO m : this.menu){
            menu.add(new Menu(m.id, m.name,m.getPrice(), m.getIngredient(), m.getOrders()));
        }
        return menu;
    }
    public List<CompoundOrd_Ingredient> getShaurma(){
        //TODO
        return null;
    }
    
}
