
package mera.shaurmar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="CustomOrder_Menu")
@SequenceGenerator(name="com_seq",sequenceName="com_seq", allocationSize=1,initialValue = 1)
public class CustomOrderMenu implements Serializable{
    private static final long serialVersionUID = 9L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="com_seq")
    private long id;
    
    @Column(name="count")
    private int count;
    
    @Column(name="size")
    @Enumerated(EnumType.STRING)
    private ShaurmaSize shaurmaSize;
    
    @OneToMany(mappedBy="com",fetch = FetchType.EAGER/*, cascade = CascadeType.REMOVE, orphanRemoval = true*/)
    private List<CustomOrderMenuIngredient> additivs  = new ArrayList<>();
    
    
    @ManyToOne
    private CustomOrder cusorder;
    
    @ManyToOne
    private Menu menuItem;
    
    public CustomOrderMenu(){}
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);;
        hash = 37 * hash + this.count;
        hash = 37 * hash + Objects.hashCode(this.shaurmaSize);
        hash = 37 * hash + Objects.hashCode(this.additivs);
        hash = 37 * hash + Objects.hashCode(this.cusorder);
        hash = 37 * hash + Objects.hashCode(this.menuItem);
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
        final CustomOrderMenu other = (CustomOrderMenu) obj;
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.shaurmaSize != other.shaurmaSize) {
            return false;
        }
        if (!Objects.equals(this.additivs, other.additivs)) {
            return false;
        }
        if (!Objects.equals(this.cusorder, other.cusorder)) {
            return false;
        }
        if (!Objects.equals(this.menuItem, other.menuItem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomOrderMenu{" + "id=" + id  + ", count=" + count + ", shaurmaSize=" + shaurmaSize + ", additivs=" + additivs +", cusorder_id=" + cusorder.getId() + ", menu=" + menuItem + '}';
    }

    public CustomOrder getCusorder() {
        return cusorder;
    }

    public void setCusorder(CustomOrder cusorder) {
        this.cusorder = cusorder;
    }

    public Menu getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(Menu menuItem) {
        this.menuItem = menuItem;
    }  
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ShaurmaSize getShaurmaSize() {
        return shaurmaSize;
    }

    public void setShaurmaSize(ShaurmaSize shaurmaSize) {
        this.shaurmaSize = shaurmaSize;
    }

    public List<CustomOrderMenuIngredient> getAdditivs() {
        return additivs;
    }

    public void setAdditivs(List<CustomOrderMenuIngredient> additivs) {
        this.additivs = additivs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   
    
}
