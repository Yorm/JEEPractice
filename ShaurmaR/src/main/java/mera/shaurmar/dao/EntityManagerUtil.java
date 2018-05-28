
package mera.shaurmar.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.*;

public class EntityManagerUtil {
    private static final EntityManagerFactory emFactory;
    static {
        try {
            emFactory = Persistence.createEntityManagerFactory("test");

        }catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

  public static EntityManager getEntityManager() {
    return emFactory.createEntityManager();

  }
}