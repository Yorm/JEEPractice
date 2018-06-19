package mera.shaurmar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="menu_seq",sequenceName="menu_seq", allocationSize=1,initialValue = 1)
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="menu_seq")
    @Column(name = "menuid")
    private long id;
    
    private String name;
    
    private float price;
    
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private List<Ingredient> ingredients = new ArrayList<>();
    
    @OneToMany(mappedBy="menu")
    private List<SimpleOrd_Menu> orders = new ArrayList<>();;


    public Menu(){}

    public Menu(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
    
    public Menu(String name,Integer price, List<Ingredient> ingredients, List<SimpleOrd_Menu> orders) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.orders = orders;
    }

    public Menu(Menu s) {
        this.id = s.getId();
        this.name = s.getName();
        this.ingredients = s.getIngredients();
        this.price = s.getPrice();
        this.orders = s.getOrders();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public void addIngOfSet(Ingredient i){
        ingredients.add(i);
    }
    
    public Ingredient getIngOfSet(int id){
        return new ArrayList<>(ingredients).get(id);
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }   

    public List<SimpleOrd_Menu> getOrders() {
        return orders;
    }

    public void setOrders(List<SimpleOrd_Menu> orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.price);
        hash = 29 * hash + Objects.hashCode(this.ingredients);
        hash = 29 * hash + Objects.hashCode(this.orders);
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.ingredients, other.ingredients)) {
            return false;
        }
        if (!Objects.equals(this.orders, other.orders)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", name=" + name + ", price=" + price + ", ingrediens=" + ingredients + ", orders=" + orders + '}';
    }


}
