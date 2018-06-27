package mera.shaurmar.service;

import java.util.Date;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.CustomOrder;
import mera.shaurmar.dto.CustomOrderDTO;
import mera.shaurmar.dto.CustomOrder_DTOStatus;
import mera.shaurmar.model.Status;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@Named
@ApplicationScoped
public class OrderService extends Service{
     
    public OrderService() {
        log = LoggerFactory.getLogger(OrderService.class);
        db = new DBService();
    }

    public CustomOrder getOrder(long id) {
        log.info("Get order" +id);
        return (CustomOrder)db.findObj(new CustomOrder(),id);
    }

    public CustomOrderDTO saveOrder(CustomOrderDTO ordDto) {  
        log.info("Save order "+ordDto);
        return db.saveOrder(ordDto);
    }

    public CustomOrder upOrder(CustomOrderDTO ordDto) {
        log.info("Update order "+ordDto);
        return db.updateOrder(ordDto);
    }
    
    public CustomOrder_DTOStatus upOrderStatus(CustomOrder_DTOStatus ordDto){
        log.info("Update order status "+ordDto.status);
        return db.updateOrderStatus(ordDto);
    }
    

    public boolean delOrder(long id) {
        log.info("Delete order "+id);
        return db.deleteObj(new CustomOrder(),id);
    }

}
