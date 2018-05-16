/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mera.annotationjpa;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.EntityManager;


public class Main {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public static void main(String[] args) {
        Main main = new Main();
        //oneToOne  
        User u1 = new User("Ragnar",23);
        User u2 = new User("Thursarukr",40);
        
        u1.setStatIp(new StatIP("255.255.255.255"));
        u2.setStatIp(new StatIP("127.0.0.1"));
        
        //oneToMany
        Telephone t1 = new Telephone("88005553535","toPor");
        Telephone t2 = new Telephone("+34567892874","ipli");
        Telephone t3 = new Telephone("88005553535","toPor");
        Telephone t4 = new Telephone("+34567892874","ipli");
        
        t1.setUser(u1);
        t2.setUser(u1);
        u1.addTel(t1);
        u1.addTel(t2);
        
        t3.setUser(u2);
        t4.setUser(u2);
        u2.addTel(t3);
        u2.addTel(t4);

        //manyToMany
        Pictures p1 = new Pictures(5,10);
        Pictures p2 = new Pictures(550,404);
        
        u1.addPic(p2);
        u1.addPic(p1);
        u2.addPic(p1);
        
        
        main.saveObj(u1);
        main.saveObj(u2);
        

    }

    public void saveObj(Object obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(obj);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("err: mera.annotationjpa.Main.saveObj()");
            entityManager.getTransaction().rollback();
        }
    }
    //TODO obj
    /*public void updateIngredient(Long id, String name) {
        try {
            entityManager.getTransaction().begin();
            Ingredient ingredient = (Ingredient) entityManager.find(Ingredient.class, id);
            ingredient.setName(name);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("err: mera.annotationjpa.Main.updateIngredient()");
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteIngredient(Long id) {
        try {
            entityManager.getTransaction().begin();
            Ingredient ingredient = (Ingredient) entityManager.find(Ingredient.class, id);
            entityManager.remove(ingredient);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("err: mera.annotationjpa.Main.deleteIngredient()");
            entityManager.getTransaction().rollback();
        }
    }*/
}