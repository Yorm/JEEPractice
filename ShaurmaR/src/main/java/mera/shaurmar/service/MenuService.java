/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mera.shaurmar.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.Menu;

/**
 *
 * @author dgolov
 */
public class MenuService {
    private Logger log;
    
    private DBService db;

    public MenuService() {
        db = new DBService();
        log = Logger.getLogger(IngredientService.class.getName());
    }
    public Menu getOne(long id){
        log.log(Level.INFO,"Get one ingredient");
        return db.findObj(new Ingredient(), id);
    }
    public boolean delOne(long id){
        log.log(Level.INFO,"Del one ingredient");
        return db.deleteObj(new Ingredient(), id);
    }
}
