package mera.shaurmar.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.Ingredient;

@Named//?
@ApplicationScoped
public class IngredientService {
    private Logger log;
    
    private DBService db;

    public IngredientService() {
        db = new DBService();
        log = Logger.getLogger(IngredientService.class.getName());
    }
    
    public Ingredient getOne(long id){
        log.log(Level.INFO,"Get one ingredient");
        return db.findObj(new Ingredient(), id);
    }
}
