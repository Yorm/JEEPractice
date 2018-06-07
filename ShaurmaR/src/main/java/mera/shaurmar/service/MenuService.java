/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mera.shaurmar.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.Menu;

@Named
@ApplicationScoped
public class MenuService  extends Service{
    
    public MenuService() {
        log = Logger.getLogger(MenuService.class.getName());
        db = new DBService();
    }
    public Menu saveOne(Menu sh){
        log.log(Level.INFO,"Save one menu pos");
        return db.saveMenu(sh);
    }
    public Menu updateOne(Menu sh){
        log.log(Level.INFO,"Update one menu pos");
        return (Menu)db.updateObj(sh, sh.getId());
    }
    public Menu getOne(long id){
        log.log(Level.INFO,"Get one menu pos");
        return db.findObj(new Menu(), id);
    }
    public boolean delOne(long id){
        log.log(Level.INFO,"Del one menu pos");
        return db.deleteObj(new Menu(), id);
    }
}
