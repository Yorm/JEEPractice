
package mera.shaurmar.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.Menu;
import mera.shaurmar.dto.MenuDTO;

@Named
@ApplicationScoped
public class MenuService extends Service{
    
    public MenuService() {
        log = LoggerFactory.getLogger(MenuService.class);
        db = new DBService();
    }
    public Menu saveMenu(MenuDTO shDto){
        
        Menu sh = new Menu();
        sh.setName(shDto.name);
        sh.setPrice(shDto.price);
        
        log.info("Save menu pos ");
        return db.saveMenu(sh);
    }
    public Menu updateMenu(MenuDTO shDto){
        Menu sh = new Menu();
        sh.setId(shDto.id);
        sh.setName(shDto.name);
        sh.setPrice(shDto.price);
        
        log.info("Update menu pos");
        return (Menu)db.updateObj(sh, sh.getId());
    }
    public MenuDTO getMenu(Long id){
        log.info("Get menu pos"); 
        Menu m = db.findObj(new Menu(), id);
        return m==null?null:new MenuDTO(m);
    }
    public boolean delMenu(Long id){
        log.info("Delete menu pos");
        return db.deleteObj(new Menu(), id);
    }
}
