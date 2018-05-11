/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mera.annotationjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerUtil {
  private static final EntityManagerFactory entityManagerFactory;
  static {
    try {
      entityManagerFactory = Persistence.createEntityManagerFactory("test");

    } catch (Throwable ex) {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();

  }
}