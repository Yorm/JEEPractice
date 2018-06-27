package mera.shaurmar.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import mera.shaurmar.dto.CustomOrderDTO;
import mera.shaurmar.dto.CustomOrderMenu_Ingredient_DTO;
import mera.shaurmar.dto.CustomOrder_DTOStatus;
import mera.shaurmar.dto.CustomOrder_Menu_DTO;
import mera.shaurmar.model.*;


public class DBService {
    private EntityManager em;
    private  Logger log;
    
    public  DBService(){
        log = LoggerFactory.getLogger(DBService.class);
        em = EntityManagerUtil.getEntityManager();
        log.info("\n");
        log.info("DBService started");
    }
    
    public Object saveObj(Object obj) {
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            log.info("merged "+ obj.getClass());
            return obj;
        } catch (Exception ex) {
            log.error("Exception: ", ex);
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
            log.error("Exception: ", ex);
            em.getTransaction().rollback();
            return null;
        }
    }
    
    public CustomOrder_DTOStatus updateOrderStatus (CustomOrder_DTOStatus ordDto) {
        CustomOrder order = (CustomOrder)findObj(new CustomOrder(), ordDto.id);
        order.setStatus(ordDto.status);
        updateObj(order,order.getId());
        return ordDto; 
    }
    
    public CustomOrder updateOrder (CustomOrderDTO ordDto) {
        CustomOrder order = (CustomOrder)findObj(new CustomOrder(), ordDto.id);
        
        order.setBuyer(ordDto.buyer);
        order.setNote(ordDto.note);
        order.setCreationDate(ordDto.creationDate);
        order.setStatus(ordDto.status);
        //order.setSum(ordDto.sum);
        
        
        //if size == size 
        List<CustomOrder_Menu> comList = new ArrayList<>();
        
        for(CustomOrder_Menu_DTO comDto : ordDto.menuSh){
            for(CustomOrder_Menu com : order.getMenu()){
                if(comDto.com_id==com.getId()){
                    //com.setId(0);
                    //com.setCusorder(order);
                    com.setCount(comDto.count);
                    com.setMenuItem(new Menu(comDto.menu.id,comDto.menu.name,comDto.menu.price));
                    com.setShaurmaSize(comDto.shaurmaSize);
                    
                    //if size == size 
                    
                    List<CustomOrderMenu_Ingredient> comiList = new ArrayList<>();
                    
                    for(CustomOrderMenu_Ingredient_DTO comiDto : comDto.additivs){
                        for(CustomOrderMenu_Ingredient comi : com.getAdditivs()){
                            //comi.setCom(com);
                            //comi.setComtable_id(0);
                            comi.setCount(comiDto.count);
                            comi.setIng(new Ingredient(comiDto.ing.id,comiDto.ing.name,comiDto.ing.price));
                            comi.setIngredientId(comiDto.ing.id);
                            comi.getIng().addOrder(comi);
                            
                            comiList.add(comi);
                        }
                    }
                    com.setAdditivs(comiList);
                    
                    comList.add(com); 
                }
            }
        }
        order.setMenu(comList);
        
        //TODO
        return order; 
    }
    
    public <T> T findObj(T cls,long id) {
        T obj;
        try {
            obj = (T) em.find(cls.getClass(), id);
        } catch (Exception ex) {
            obj=null;
            log.error("Exception: ", ex);
        }
        log.info("Find: " + obj);
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
            log.error("Exception: ", ex);
            em.getTransaction().rollback();
        }   
        return obj!=null;
    }
    
    public CustomOrder orderDTOtoOrder(CustomOrderDTO ordDto){
        CustomOrder order = new CustomOrder();
        
        float sum =0f;
        order.setBuyer(ordDto.buyer);
        order.setNote(ordDto.note);
        order.setCreationDate(new Date());
        order.setStatus(Status.NEW);
        
        List<CustomOrder_Menu> comList = new ArrayList<>();
        for(CustomOrder_Menu_DTO comDto : ordDto.menuSh){
            CustomOrder_Menu comItem = new CustomOrder_Menu();
            comItem.setCount(comDto.count);
            comItem.setShaurmaSize(comDto.shaurmaSize);
            comItem.setCusorder(order);
            
            Menu m = (Menu)findObj(new Menu(),comDto.menu.id);
            if(m==null){
                m = new Menu("not found",404f);
            }
            
            comItem.setMenuItem(m);
            sum+=m.getPrice()*(comItem.getCount()==0?1:comItem.getCount());
            
            Query q = em.createNativeQuery("select nextval('public.com_seq')");
            long seqValue=(long)q.getSingleResult()+1;//'+1' - because when you apply - it is incremented

            comItem.setId(seqValue);
            
            List<CustomOrderMenu_Ingredient> comiList = new ArrayList<>();
            for(CustomOrderMenu_Ingredient_DTO comiDto : comDto.additivs){
                CustomOrderMenu_Ingredient comiItem = new CustomOrderMenu_Ingredient();
                comiItem.setCount(comiDto.count);
                comiItem.setCom(comItem);
                comiItem.setComtable_id(seqValue);
                
                Ingredient ing = (Ingredient)findObj(new Ingredient(),comiDto.ing.id);
                
                if(ing==null){
                    ing = new Ingredient("not found",404f);
                }
                comiItem.setIngredientId(ing.getId());
                ing.addOrder(comiItem);
                sum+=ing.getPrice()*(comiItem.getCount()==0?1:comiItem.getCount());
                comiItem.setIng(ing);
                
                comiList.add(comiItem);
                
            }
            comItem.setAdditivs(comiList);
            
            comList.add(comItem);
        }
        
        order.setMenu(comList); 
        order.setSum(sum);
        
        return order;
    }
   
    public CustomOrderDTO saveOrder(CustomOrderDTO ordDto){
        CustomOrder order = orderDTOtoOrder(ordDto);
        
        try {
            em.getTransaction().begin();
            em.merge(order);
            em.getTransaction().commit();
        } catch (Exception ex) {
            log.error("Exception: ", ex);
            em.getTransaction().rollback();
        }
      
        return ordDto;
    }
    
    public Menu saveMenu(Menu m)  { 
        Query query = em.createQuery("Select m FROM Menu m WHERE m.name = :name");
        query.setParameter("name", m.getName());
        
        if(!query.getResultList().isEmpty()){
            log.error("menu "+m.getName()+" already exists");
            return new Menu("already exists",404f);
        }
        
        try {
            em.getTransaction().begin();
            em.merge(m);
            em.getTransaction().commit();
        } catch (Exception ex) {
            log.error("Exception: ", ex);
            em.getTransaction().rollback();
        }
        return m;
    }
    public Ingredient saveIngredient(Ingredient ing)  {  
        Query query = em.createQuery("Select ing FROM Ingredient ing WHERE ing.name = :name");
        query.setParameter("name", ing.getName());
        
        if(!query.getResultList().isEmpty()){
            log.error("ingredient "+ing.getName()+" already exists");
            return new Ingredient("already exists",404f);
        }
        
        try {
            em.getTransaction().begin();
            em.merge(ing);
            em.getTransaction().commit();
        } catch (Exception ex) {
            log.error("Exception: ", ex);
            em.getTransaction().rollback();
        }
        return ing;
    }
}
