package mera.shaurmar.service;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.CustomOrder;
import mera.shaurmar.dto.CustomOrderDTO;
import mera.shaurmar.dto.CustomOrderDTOStatus;
import mera.shaurmar.dto.CustomOrderUpdateDTO;
import mera.shaurmar.model.Status;
import org.slf4j.LoggerFactory;


@Named
@ApplicationScoped
public class OrderService extends Service{
     
    public OrderService() {
        log = LoggerFactory.getLogger(OrderService.class);
        db = new DBService();
    }

    public ArrayList<CustomOrder> getAll(){
        log.debug("Get all menu!!!");
        ArrayList<CustomOrder> menus = db.getAll(
                new ArrayList<CustomOrder>(){{
                    add(new CustomOrder());
                }});
        return menus==null?null:menus;
    }
    
    public CustomOrderUpdateDTO getOrder(long id) {
        log.debug("Get order" +id);
        CustomOrder ord = (CustomOrder)db.findObj(new CustomOrder(),id);
        System.out.println("before CLABS "+ord.toString());
        if(ord==null) return null;

        CustomOrderUpdateDTO ordDto = new CustomOrderUpdateDTO();
        ordDto.buyer=ord.getBuyer();
        ordDto.creationDate=ord.getCreationDate();
        ordDto.id=ord.getId();        
        //ordDto.menuSh=ord.getMenu(); ???? ERR
        ordDto.note=ord.getNote();
        ordDto.status=ord.getStatus();
        ordDto.sum=ord.getSum();
        return ordDto;
    }

    public CustomOrderDTO saveOrder(CustomOrderDTO ordDto) {  
        log.debug("Save order "+ordDto);
        return db.saveOrder(ordDto);
    }

    public CustomOrder updateOrder(CustomOrderDTO ordDto) {
        log.debug("Update order "+ordDto);
        return db.updateOrder(ordDto);
    }
    
    public CustomOrderDTOStatus upOrderStatus(CustomOrderDTOStatus ordDto){
        log.debug("Update order status "+ordDto.status);
        return db.updateOrderStatus(ordDto);
    }
    

    public boolean delOrder(long id) {
        log.debug("Delete order "+id);
        return db.deleteOrder(id);
    }

}
