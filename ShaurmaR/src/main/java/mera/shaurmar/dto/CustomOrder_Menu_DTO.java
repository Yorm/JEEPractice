package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.CustomOrder;
import mera.shaurmar.model.CustomOrderMenu_Ingredient;
import mera.shaurmar.model.Menu;
import mera.shaurmar.model.ShaurmaSize;

public class CustomOrder_Menu_DTO {
    public long com_id;
    public ShaurmaSize shaurmaSize;
    public int count;
    public CustomOrder cusorder;
    public MenuDTO menu;
    public List<CustomOrderMenu_Ingredient_DTO> additivs  = new ArrayList<>();

    @Override
    public String toString() {
        return "CustomOrder_Menu_DTO{" + "com_id=" + com_id + ", shaurmaSize=" + shaurmaSize + ", count=" + count + ", cusorder=" + cusorder + ", menu=" + menu + ", additivs=" + additivs + '}';
    }

    
    
}
