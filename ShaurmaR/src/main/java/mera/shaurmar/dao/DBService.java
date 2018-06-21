package mera.shaurmar.dao;

import java.util.List;
import java.util.logging.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    
    public Object saveObj(Object obj) {
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            log.log(Level.INFO, "merged "+ obj.getClass());
            return obj;
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Exception: ", ex);
            em.getTransaction().rollback();
            return null;
        }
    }
    
    public <T> T updateObj(T cls,long id) {
        try {
            em.getTransaction().begin();
            em.merge(cls);
            em.getTransaction().commit();  
            return cls;
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Exception: ", ex);
            em.getTransaction().rollback();
            return null;
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
    
    public <T> boolean deleteObj(T cls, Long id) {
        T obj=null;
        try {
            em.getTransaction().begin();
            obj = (T) em.find(cls.getClass(), id);
            if (obj != null) {
                em.remove(obj);
            }
            em.getTransaction().commit(); 
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Exception: ", ex);
            em.getTransaction().rollback();
        }   
        return obj!=null;
    }
    
    public Menu saveMenu(Menu m)  { 
        {
            List<Menu> menuRes = em.createQuery("SELECT name FROM Menu name", Menu.class).getResultList();    
            for(int i=0; i<menuRes.size();i++){
                if(m.getName().compareTo(menuRes.get(i).getName())==0){
                        log.log(Level.SEVERE, "menu "+m.getName()+" already exists");
                        return new Menu("already exists",404f);
                }
            }
        }
        List<Ingredient> ingRes = em.createQuery("SELECT name FROM Ingredient name", Ingredient.class).getResultList();    
        for(int i=0; i<m.getIngredients().size();i++){
            for(int j=0; j<ingRes.size();j++){
                if(m.getIngredients().get(i).getName().compareTo(ingRes.get(j).getName())==0){
                    m.getIngredients().get(i).setId(ingRes.get(j).getId());
                }     
            } 
        }
        try {
            em.getTransaction().begin();
            em.merge(m);
            em.getTransaction().commit();
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Exception: ", ex);
            em.getTransaction().rollback();
        }
        return m;
    }
    public Ingredient saveIngredient(Ingredient ing)  {  
        Query query = em.createQuery("Select ing FROM Ingredient ing WHERE ing.name = :name");
        query.setParameter("name", ing.getName());
        
        if(!query.getResultList().isEmpty()){
            log.log(Level.SEVERE, "ingredient "+ing.getName()+" already exists");
            return new Ingredient("already exists",404f);
        }
        
        try {
            em.getTransaction().begin();
            em.merge(ing);
            em.getTransaction().commit();
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Exception: ", ex);
            em.getTransaction().rollback();
        }
        return ing;
    }
}
