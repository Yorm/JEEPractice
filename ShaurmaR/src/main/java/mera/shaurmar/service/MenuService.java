
package mera.shaurmar.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.Menu;
import mera.shaurmar.dto.MenuDTO;

@Named
@ApplicationScoped
public class MenuService  extends Service{
    
    public MenuService() {
        log = Logger.getLogger(MenuService.class.getName());
        db = new DBService();
    }
    public Menu saveMenu(MenuDTO shDto){
        
        Menu sh = new Menu();
        sh.setIngredients(shDto.getIngredient());
        sh.setName(shDto.name);
        sh.setPrice(shDto.getPrice());
        
        log.log(Level.INFO,"Save menu pos");
        return db.saveMenu(sh);
    }
    public Menu updateMenu(Menu sh){
        log.log(Level.INFO,"Update menu pos");
        return (Menu)db.updateObj(sh, sh.getId());
    }
    public Menu getMenu(Long id){
        log.log(Level.INFO,"Get menu pos");
        return db.findObj(new Menu(), id);
    }
    public boolean delMenu(Long id){
        log.log(Level.INFO,"Delete menu pos");
        return db.deleteObj(new Menu(), id);
    }
}
