
package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.Ingredient;
import mera.shaurmar.model.CustomOrder_Menu;


public class MenuDTO {
    public Long id;
    public String name;
    public Float price;
    private List<CustomOrder_Menu_DTO> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "MenuDTO{" + "id=" + id + ", name=" + name + ", price=" + price + ", orders=" + orders + '}';
    }
    

}
