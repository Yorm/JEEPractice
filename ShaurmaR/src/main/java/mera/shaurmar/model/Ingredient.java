package mera.shaurmar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="ing_seq",sequenceName="ing_seq", allocationSize=1,initialValue = 1)
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ing_seq")
    private long id;
    private String name;
    private Float price;
    
    @OneToMany(mappedBy="ing"/*, cascade = CascadeType.PERSIST*/)
    private List<CustomOrderMenu_Ingredient> orders = new ArrayList<>();;
    
    public Ingredient(){}

    public Ingredient(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Ingredient(long id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public Ingredient(Ingredient i) {
        this.id = i.getId();
        this.name = i.getName();
        this.price = i.getPrice();
    }

    public void addOrder(CustomOrderMenu_Ingredient ord){
        orders.add(ord);  
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }


    public List<CustomOrderMenu_Ingredient> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomOrderMenu_Ingredient> orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.price);
        hash = 71 * hash + Objects.hashCode(this.orders);
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
        final Ingredient other = (Ingredient) obj;
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
        return "Ingredient{" + "id=" + id + ", name=" + name + ", price=" + price + ", orders=" + orders + '}';
    }
    

}
