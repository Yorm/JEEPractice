/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mera.annotationjpa;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;


public class Main {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public static void main(String[] args) {
        Main main = new Main();
             
        User u1 = new User("Ragnar",23);
        User u2 = new User("Thursarukr",40);
        
        u1.setStatIp(new StatIP("255.255.255.255"));
        u2.setStatIp(new StatIP("127.0.0.1"));
        
        Telephone t1 = new Telephone("88005553535","toPor");
        Telephone t2 = new Telephone("+34567892874","ipli");
        ArrayList<Telephone> tel = new ArrayList<>();
        t1.setUser(u2);
        t2.setUser(u2);
        tel.add(t1);
        tel.add(t2);
        u2.setTel(tel);

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