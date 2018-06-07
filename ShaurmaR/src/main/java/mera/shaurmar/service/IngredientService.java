package mera.shaurmar.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.Ingredient;

@Named
@ApplicationScoped
public class IngredientService  extends Service{

    public IngredientService() { 
        log = Logger.getLogger(IngredientService.class.getName());
        db = new DBService();
    }
    
    public Ingredient saveOne(Ingredient ing){
        log.log(Level.INFO,"Save one ingredient");
        return (Ingredient)db.saveObj(ing);
    }
    public Ingredient updateOne(Ingredient ing){
        log.log(Level.INFO,"Update one ingredient");
        return (Ingredient)db.updateObj(ing, ing.getId());
    }
    public Ingredient getOne(long id){
        log.log(Level.INFO,"Get one ingredient");
        return db.findObj(new Ingredient(), id);
    }
    public boolean delOne(long id){
        log.log(Level.INFO,"Del one ingredient");
        return db.deleteObj(new Ingredient(), id);
    }  
}
