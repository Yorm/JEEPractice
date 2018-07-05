
package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import mera.shaurmar.model.Menu;

public class MenuDTO {
    //@Null
    public Long id;
    @NotNull
    public String name;
    @NotNull
    public double price;

    public MenuDTO(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.price = menu.getPrice();
    }

    public MenuDTO() {
    }

    @Override
    public String toString() {
        return "MenuDTO{" + "id=" + id + ", name=" + name + ", price=" + price +  '}';
    }
 

}
