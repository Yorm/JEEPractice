
package mera.shaurmar.service;

import java.util.ArrayList;
import org.slf4j.LoggerFactory;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.Menu;
import mera.shaurmar.dto.MenuDTO;
import mera.shaurmar.model.Ingredient;

@Named
@ApplicationScoped
public class MenuService extends Service{
    
    public MenuService() {
        log = LoggerFactory.getLogger(MenuService.class);
        db = new DBService();
    }
    
    public ArrayList<Menu> getAll(){
        log.debug("Get all menu!!!");
        ArrayList<Menu> menus = db.getAll(
                new ArrayList<Menu>(){{
                    add(new Menu());
                }});
        return menus==null?null:menus;
    }
    
    
    public Menu saveMenu(MenuDTO shDto){
        Menu sh = new Menu();
        sh.setName(shDto.name);
        sh.setPrice(shDto.price);
        
        log.debug("Save menu pos ");
        return db.saveMenu(sh);
    }
    public Menu updateMenu(MenuDTO shDto){
        Menu sh = new Menu();
        sh.setId(shDto.id);
        sh.setName(shDto.name);
        sh.setPrice(shDto.price);
        
        log.debug("Update menu pos");
        return (Menu)db.updateObj(sh, sh.getId());
    }
    public MenuDTO getMenu(Long id){
        log.debug("Get menu pos"); 
        Menu m = db.findObj(new Menu(), id);
        return m==null?null:new MenuDTO(m);
    }
    public boolean delMenu(Long id){
        log.debug("Delete menu pos");
        return db.deleteObj(new Menu(), id);
    }
}
