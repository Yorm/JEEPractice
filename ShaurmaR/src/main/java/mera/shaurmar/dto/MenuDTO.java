
package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.Ingredient;
import mera.shaurmar.model.CustomOrder_Menu;
import mera.shaurmar.model.Menu;

public class MenuDTO {
    public Long id;
    public String name;
    public Float price;
    private List<CustomOrder_Menu_DTO> orders = new ArrayList<>();

    public MenuDTO(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.price = menu.getPrice();
    }

    public MenuDTO() {
    }

    @Override
    public String toString() {
        return "MenuDTO{" + "id=" + id + ", name=" + name + ", price=" + price + ", orders=" + orders + '}';
    }
 

}
