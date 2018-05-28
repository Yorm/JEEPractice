package mera.shaurmar.dao;

import java.util.logging.*;
import javax.persistence.EntityManager;
import mera.shaurmar.model.*;


public class DBService {
    private EntityManager em;
    private Logger log;
    
    public  DBService(){
        log = Logger.getLogger(DBService.class.getName());
        em = EntityManagerUtil.getEntityManager();
        log.info("\n");
        log.info("DBService started");
    }
    
    public void saveObj(Object obj) {
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            log.info(obj.getClass() + " merged");
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Exception: ", ex);
            em.getTransaction().rollback();
        }
    }
    
    public <T> T findObj(T cls,long id) {
        T obj;
        try {
            em.getTransaction().begin();
            obj = (T) em.find(cls.getClass(), id);
            log.log(Level.INFO, "Find: " + obj);
            em.getTransaction().commit(); 
        } catch (Exception ex) {
            obj=null;
            log.log(Level.SEVERE, "Exception: ", ex);
            em.getTransaction().rollback();
        }
        return obj;
    }
}
