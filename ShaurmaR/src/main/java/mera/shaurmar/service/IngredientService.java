package mera.shaurmar.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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
        log.info("Save ingredient");
        return db.saveIngredient(new Ingredient(ingDto.name, ingDto.price));
    }
    public Ingredient updateIng(IngredientDTO ingDto){
        Ingredient ing = new Ingredient();
        ing.setId(ingDto.id);
        ing.setName(ingDto.name);
        ing.setPrice(ingDto.price);
        
        log.info("Update ingredient");
        return (Ingredient)db.updateObj(ing, ing.getId());
    }
    public Ingredient getIng(Long id){
        log.info("Get ingredient");
        return db.findObj(new Ingredient(), id);
    }
    public boolean delIng(Long id){
        log.info("Delete ingredient");
        return db.deleteObj(new Ingredient(), id);
    }  
}
