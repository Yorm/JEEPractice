package mera.shaurmar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
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
    
    private Integer price;
    
    @ManyToMany
    private Set<Ingredient> ingrediens = new HashSet<>();
    
    @ManyToMany(mappedBy="menuSh")
    private Set<SimpleOrd> orders  = new HashSet<>();

    public Menu(){}

    public Menu(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
    
    public Menu(String name,Integer price, Set<Ingredient> ingrediens , Set<SimpleOrd> orders) {
        this.name = name;
        this.price = price;
        this.ingrediens = ingrediens;
        this.orders = orders;
    }

    public Menu(Menu s) {
        this.id = s.getId();
        this.name = s.getName();
        this.ingrediens = s.getIngrediens();
        this.price = s.getPrice();
        this.orders = s.getOrders();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public void addIngOfSet(Ingredient i){
        ingrediens.add(i);
    }
    
    public Ingredient getIngOfSet(int id){
        return new ArrayList<>(ingrediens).get(id);
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

    public Set<Ingredient> getIngrediens() {
        return ingrediens;
    }

    public void setIngrediens(Set<Ingredient> setOfIng) {
        this.ingrediens = setOfIng;
    }

    public Set<SimpleOrd> getOrders() {
        return orders;
    }

    public void setOrders(Set<SimpleOrd> orders) {
        this.orders = orders;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.ingrediens);
        hash = 67 * hash + Objects.hashCode(this.orders);
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
        if (!Objects.equals(this.ingrediens, other.ingrediens)) {
            return false;
        }
        if (!Objects.equals(this.orders, other.orders)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", name=" + name + ", setOfIng=" + ingrediens +  ", ordrers=" + orders + '}';
    }
}
