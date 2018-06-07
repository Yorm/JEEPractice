package mera.shaurmar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="ing_seq",sequenceName="ing_seq", allocationSize=1,initialValue = 1)
public class Ingredient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ing_seq")
    @Column(name = "ingid")
    private long id;
    private String name;
    private Integer price;
    
    @ManyToMany(mappedBy="ingredients",cascade = CascadeType.MERGE)
    private List<Menu> menu  = new ArrayList<>();
    
    @ManyToMany(mappedBy="compoundSh")
    private Set<CompoundOrd> shaurma  = new HashSet<>();
    
    public Ingredient(){}

    public Ingredient(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Ingredient(Ingredient i) {
        this.id = i.getId();
        this.name = i.getName();
        this.price = i.getPrice();
        this.menu = i.getMenu();
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<CompoundOrd> getShaurma() {
        return shaurma;
    }

    public void setShaurma(Set<CompoundOrd> shaurma) {
        this.shaurma = shaurma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.price);
        hash = 67 * hash + Objects.hashCode(this.menu);
        hash = 67 * hash + Objects.hashCode(this.shaurma);
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.menu, other.menu)) {
            return false;
        }
        if (!Objects.equals(this.shaurma, other.shaurma)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "id=" + id + ", name=" + name + ", price=" + price + ", menu=" + menu + ", shaurma=" + shaurma + '}';
    }

   

   
 
}
