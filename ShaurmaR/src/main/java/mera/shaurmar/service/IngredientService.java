package mera.shaurmar.service;

import java.util.ArrayList;
import org.slf4j.LoggerFactory;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.dto.IngredientDTO;
import mera.shaurmar.model.Ingredient;

@Named
@ApplicationScoped
public class IngredientService  extends Service{

    public IngredientService() { 
        log = LoggerFactory.getLogger(IngredientService.class);
        db = new DBService();
    }
    
    public Ingredient saveIng(IngredientDTO ingDto){
        log.debug("Save ingredient");
        return db.saveIngredient(new Ingredient(ingDto.name, ingDto.price));
    }
    public Ingredient updateIng(IngredientDTO ingDto){
        Ingredient ing = new Ingredient();
        ing.setId(ingDto.id);
        ing.setName(ingDto.name);
        ing.setPrice(ingDto.price);
        
        log.debug("Update ingredient");
        return (Ingredient)db.updateObj(ing, ing.getId());
    }
    
    public ArrayList<Ingredient> getAll(){
        log.debug("Get all ingredients");
        ArrayList<Ingredient> ings = db.getAll(
                new ArrayList<Ingredient>(){{
                    add(new Ingredient());
                }});
        return ings==null?null:ings;
    }
    
    public IngredientDTO getIng(Long id){
        Ingredient ing = db.findObj(new Ingredient(), id);
        log.debug("Get ingredient");
        return ing==null?null:new IngredientDTO(ing);
    }
    public boolean delIng(Long id){
        log.debug("Delete ingredient");
        return db.deleteObj(new Ingredient(), id);
    }  
}
