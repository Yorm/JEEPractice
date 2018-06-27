package mera.shaurmar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="menu_seq",sequenceName="menu_seq", allocationSize=1,initialValue = 1)
public class Menu implements Serializable {
    private static final long serialVersionUID = 2L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="menu_seq")
    private Long id;
    
    private String name;
    
    private Float price;
    
    
    @OneToMany(mappedBy="menuItem")
    private List<CustomOrder_Menu> orders = new ArrayList<>();;

    public Menu(){}

    public Menu(String name, Float price) {
        this.name = name;
        this.price = price;
    }
    public Menu(long id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public Menu(String name,Float price, List<Ingredient> ingredients, List<CustomOrder_Menu> orders) {
        this.name = name;
        this.price = price;
        this.orders = orders;
    }
    public Menu(Long id, String name,Float price, List<Ingredient> ingredients, List<CustomOrder_Menu> orders) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orders = orders;
    }

    public Menu(Menu s) {
        this.id = s.getId();
        this.name = s.getName();
        this.price = s.getPrice();
        this.orders = s.getOrders();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.price);
        hash = 47 * hash + Objects.hashCode(this.orders);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }

        if (!Objects.equals(this.orders, other.orders)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", name=" + name + ", price=" + price +  ", orders=" + orders + '}';
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CustomOrder_Menu> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomOrder_Menu> orders) {
        this.orders = orders;
    }

}
