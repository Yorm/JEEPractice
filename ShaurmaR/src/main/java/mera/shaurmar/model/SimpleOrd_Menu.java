/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mera.shaurmar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="simpleord_menu")
@IdClass(SOM_Key.class)
public class SimpleOrd_Menu implements Serializable{
    private static final long serialVersionUID = 9L;
    
    @Id
    private long menuId;
    @Id
    private long simpleordId;
    
    @Column(name="count")
    private int count;
    
    @Column(name="size")
    @Enumerated(EnumType.STRING)
    private ShaurmaSize shaurmaSize;
    
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private List<Ingredient> additivs  = new ArrayList<>();
    
    public SimpleOrd_Menu(){}
    
    @ManyToOne
    @PrimaryKeyJoinColumn ( name = "menuId" ,  referencedColumnName = "menuid" ) 
    //@JoinColumn (name = "menuId", updatable = false, insertable = false, referencedColumnName = "id") 
    private Menu menu;
    
    @ManyToOne
    @PrimaryKeyJoinColumn ( name = "simpleordId" ,  referencedColumnName = "ordid" ) 
    //@JoinColumn (name = "simpleordId", updatable = false, insertable = false, referencedColumnName = "id") 
    private SimpleOrd simpleord;

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public long getSimpleordId() {
        return simpleordId;
    }

    public void setSimpleordId(long simpleordId) {
        this.simpleordId = simpleordId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public SimpleOrd getSimpleord() {
        return simpleord;
    }

    public void setSimpleord(SimpleOrd simpleord) {
        this.simpleord = simpleord;
    }

    public ShaurmaSize getSize() {
        return shaurmaSize;
    }

    public void setSize(ShaurmaSize size) {
        this.shaurmaSize = size;
    }

    public ShaurmaSize getShaurmaSize() {
        return shaurmaSize;
    }

    public void setShaurmaSize(ShaurmaSize shaurmaSize) {
        this.shaurmaSize = shaurmaSize;
    }

    public List<Ingredient> getAdditivs() {
        return additivs;
    }

    public void setAdditivs(List<Ingredient> additivs) {
        this.additivs = additivs;
    }
    
    
    
}
