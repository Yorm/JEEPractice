package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.CustomOrder;
import mera.shaurmar.model.ShaurmaSize;

public class CustomOrderMenuDTO {
    public long com_id;
    public ShaurmaSize shaurmaSize;
    public int count;
    public CustomOrder cusorder;
    public MenuDTO menu;
    public List<CustomOrderMenuIngredientDTO> additivs  = new ArrayList<>();

    @Override
    public String toString() {
        return "CustomOrderMenuDTO{" + "com_id=" + com_id + ", shaurmaSize=" + shaurmaSize + ", count=" + count + ", cusorder=" + cusorder + ", menu=" + menu + ", additivs=" + additivs + '}';
    }

    
    
}
