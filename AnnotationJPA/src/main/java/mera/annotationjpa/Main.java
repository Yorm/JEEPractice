/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mera.annotationjpa;


import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

/*
Познакомиться с тем, что такое entity, какие есть аннотации. 
Разобраться с аннотациями: 
@Entity+
@Id+
@Access
@Transient 
@Table
@Column 
@Enumerated
@Temporal
@Embedded
Знать чем отличается Lazy loading от Eager.
Знать стратегии @GeneratedValue (@TableGenerator, ...)
Знать как мапится иерархия классов в таблицы базы данных
Как написать Converter для сохраняемых значений
*/
public class Main {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public static void main(String[] args) {
        Main main = new Main();
        main.saveIngredient("one");
        main.saveIngredient("two");
        main.saveIngredient("three");
        main.saveIngredient("four");
        
    }

    public Ingredient saveIngredient(String name) {
        Ingredient ingredient = new Ingredient();
        try {
            entityManager.getTransaction().begin();
            ingredient.setName(name);
            ingredient = entityManager.merge(ingredient);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
           
            entityManager.getTransaction().rollback();
        }
        return ingredient;
    }

    public void updateIngredient(Long id, String name) {
        try {
            entityManager.getTransaction().begin();
            Ingredient ingredient = (Ingredient) entityManager.find(Ingredient.class, id);
            ingredient.setName(name);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
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
            entityManager.getTransaction().rollback();
        }
    }
}