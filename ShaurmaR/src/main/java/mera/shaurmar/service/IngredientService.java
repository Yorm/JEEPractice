package mera.shaurmar.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.dto.IngredientDTO;
import mera.shaurmar.model.Ingredient;

@Named
@ApplicationScoped
public class IngredientService  extends Service{

    public IngredientService() { 
        log = Logger.getLogger(IngredientService.class.getName());
        db = new DBService();
    }
    
    public Ingredient saveIng(IngredientDTO ingDto){
        log.log(Level.INFO,"Save ingredient");
        return db.saveIngredient(new Ingredient(ingDto.name, ingDto.price));
    }
    public Ingredient updateIng(IngredientDTO ingDto){
        Ingredient ing = new Ingredient();
        ing.setId(ingDto.id);
        ing.setName(ingDto.name);
        ing.setPrice(ingDto.price);
        ing.setMenu(ingDto.getMenu());
        ing.setShaurma(ingDto.getShaurma());
        
        log.log(Level.INFO,"Update ingredient");
        return (Ingredient)db.updateObj(ing, ing.getId());
    }
    public Ingredient getIng(Long id){
        log.log(Level.INFO,"Get ingredient");
        return db.findObj(new Ingredient(), id);
    }
    public boolean delIng(Long id){
        log.log(Level.INFO,"Delete ingredient");
        return db.deleteObj(new Ingredient(), id);
    }  
}
