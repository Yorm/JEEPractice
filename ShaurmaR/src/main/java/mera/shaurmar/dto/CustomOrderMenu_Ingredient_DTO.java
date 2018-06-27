package mera.shaurmar.dto;

import mera.shaurmar.model.CustomOrder_Menu;
import mera.shaurmar.model.Ingredient;


public class CustomOrderMenu_Ingredient_DTO {
    public long ingid;
    public long comid;
    public int count;
    public CustomOrder_Menu_DTO com;
    public IngredientDTO ing;   

    @Override
    public String toString() {
        return "CustomOrderMenu_Ingredient_DTO{" + "ingid=" + ingid + ", comid=" + comid + ", count=" + count + ", com=" + com + ", ing=" + ing + '}';
    }
    
}
