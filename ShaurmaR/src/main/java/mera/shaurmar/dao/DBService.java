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
import mera.shaurmar.dto.CustomOrder_UpdateDTO;
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
            if(em.find(cls.getClass(), id)==null){
                throw new Exception();
            }
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
        return updateObj(order,order.getId())==null?null:ordDto; 
    }
    
    public CustomOrder updateOrder (CustomOrder_UpdateDTO ordDto) {
        CustomOrder order = (CustomOrder)findObj(new CustomOrder(), ordDto.id);
        
        order.setBuyer(ordDto.buyer);
        order.setNote(ordDto.note);
        order.setCreationDate(ordDto.creationDate);
        order.setStatus(ordDto.status);
        order.setSum(ordDto.sum);
        order.setMenu( ordDto.menuSh);      

        return updateObj(order,order.getId())==null?null:order; 
    }
    
    public <T> T findObj(T cls,long id) {
        T obj;
        try {
            obj = (T) em.find(cls.getClass(), id);
            return obj;
        } catch (Exception ex) {
            log.error("Exception: ", ex);
            return null;  
        }      
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
    
    public boolean deleteOrder(long id){
        //get ord
        CustomOrder ord = em.find(CustomOrder.class, id); if(ord==null) return false;
        
        //get ord_menu
        Query queryCom = em.createQuery("Select com FROM CustomOrder_Menu com"); 
        if(queryCom.getResultList().isEmpty()){    
            return false;
        }
        List<CustomOrder_Menu> ord_menu=new ArrayList<>();
        for(int i=0;i<queryCom.getResultList().size();i++){
            CustomOrder_Menu com = (CustomOrder_Menu) queryCom.getResultList().get(i);
            if(com.getCusorder().getId()==id){
                ord_menu.add(com); 
            }
        }
        //get ordMenu_ing
        Query queryComi = em.createQuery("Select comi FROM CustomOrderMenu_Ingredient comi"); 
        if(queryComi.getResultList().isEmpty()){    
            return false;
        }
        List<CustomOrderMenu_Ingredient> ordMenu_ing=new ArrayList<>();
        for(int j=0;j<ord_menu.size();j++){
            for(int i=0;i<queryComi.getResultList().size();i++){
                CustomOrderMenu_Ingredient comi = (CustomOrderMenu_Ingredient) queryComi.getResultList().get(i);
                if(comi.getComtable_id()==ord_menu.get(j).getId()){
                    ordMenu_ing.add(comi); 
                }
            }
        }
        //del ordMenu_ing
        //del ord_menu
        //del ord
        for(int i=0; i<ordMenu_ing.size();i++){
            try {
                em.getTransaction().begin();
                em.remove(ordMenu_ing.get(i));
                log.info("delete "+ordMenu_ing.get(i));
                em.getTransaction().commit(); 
            } catch (Exception ex) {
                log.error("Exception: ", ex);
                em.getTransaction().rollback();
            }   
        }
        for(int i=0; i<ord_menu.size();i++){
            try {
                em.getTransaction().begin();
                em.remove(ord_menu.get(i));
                log.info("delete "+ord_menu.get(i));
                em.getTransaction().commit(); 
            } catch (Exception ex) {
                log.error("Exception: ", ex);
                em.getTransaction().rollback();
            }   
        }
        try {
            em.getTransaction().begin();
            em.remove(ord);
            log.info("delete "+ord);
            em.getTransaction().commit(); 
        } catch (Exception ex) {
            log.error("Exception: ", ex);
            em.getTransaction().rollback();
        }   
        
        return true;
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
                return null;
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
                    return null;
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
        if(order==null) return null;
        try {  
            em.getTransaction().begin();
            em.merge(order);
            em.getTransaction().commit();
            return ordDto;
        } catch (Exception ex) {
            log.error("Exception: ", ex);
            em.getTransaction().rollback();
            return null;
        }      
    }
    
    public Menu saveMenu(Menu m)  { 
        Query query = em.createQuery("Select m FROM Menu m WHERE m.name = :name");
        query.setParameter("name", m.getName());
        
        if(!query.getResultList().isEmpty()){
            log.error("Menu "+m.getName()+" already exists");
            return null;
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
            return null;
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
