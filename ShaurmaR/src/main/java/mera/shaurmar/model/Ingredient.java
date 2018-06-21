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
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ing_seq")
    @Column(name = "ingid")
    private Long id;
    private String name;
    private Float price;
    
    @ManyToMany(mappedBy="additivs",cascade = CascadeType.MERGE)
    private List<SimpleOrd_Menu> simpleOrd  = new ArrayList<>();
    
    @ManyToMany(mappedBy="ingredients",cascade = CascadeType.MERGE)
    private List<Menu> menu  = new ArrayList<>();
    
    @OneToMany(mappedBy="ing")
    private List<CompoundOrd_Ingredient> shaurma = new ArrayList<>();;
    
    public Ingredient(){}

    public Ingredient(String name, Float price) {
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

    public List<CompoundOrd_Ingredient> getShaurma() {
        return shaurma;
    }

    public void setShaurma(List<CompoundOrd_Ingredient> shaurma) {
        this.shaurma = shaurma;
    }

    public List<SimpleOrd_Menu> getSimpleOrd() {
        return simpleOrd;
    }

    public void setSimpleOrd(List<SimpleOrd_Menu> simpleOrd) {
        this.simpleOrd = simpleOrd;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.price);
        hash = 59 * hash + Objects.hashCode(this.simpleOrd);
        hash = 59 * hash + Objects.hashCode(this.menu);
        hash = 59 * hash + Objects.hashCode(this.shaurma);
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
        if (!Objects.equals(this.simpleOrd, other.simpleOrd)) {
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
        return "Ingredient{" + "id=" + id + ", name=" + name + ", price=" + price + ", simpleOrd=" + simpleOrd + ", menu=" + menu + ", shaurma=" + shaurma + '}';
    }





}
