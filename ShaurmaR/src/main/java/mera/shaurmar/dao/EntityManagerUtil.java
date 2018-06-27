
package mera.shaurmar.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityManagerUtil {
    private static Logger log = LoggerFactory.getLogger(EntityManagerUtil.class);
    private static final EntityManagerFactory emFactory;
    static {
        try {
            emFactory = Persistence.createEntityManagerFactory("test");

        }catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

  public static EntityManager getEntityManager() {
    return emFactory.createEntityManager();
  }
}