package mera.shaurmar.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.CustomOrder;
import mera.shaurmar.dto.CustomOrderDTO;
import mera.shaurmar.dto.CustomOrderDTOStatus;
import mera.shaurmar.dto.CustomOrderUpdateDTO;
import mera.shaurmar.model.CustomOrderMenu;
import mera.shaurmar.model.CustomOrderMenuIngredient;
import mera.shaurmar.model.Menu;
import mera.shaurmar.model.ShaurmaSize;
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
        ArrayList<CustomOrder> cos = db.getAll(
                new ArrayList<CustomOrder>(){{
                    add(new CustomOrder());
                }});
        
        if(cos==null) return null;
        for(int idx=0;idx<cos.size();idx++){
            orderCleaning(cos.get(idx));
        }
        return cos;
    }
    
    public CustomOrder getOrder(long id) {
        log.debug("Get order" +id);
        CustomOrder order = (CustomOrder)db.findObj(new CustomOrder(),id);
        if(order==null) return null;   
        return orderCleaning(order);
    }

    public CustomOrder saveOrder(CustomOrderDTO oDto) {  
        log.debug("Save order "+oDto);
        CustomOrder order = db.saveOrder(oDto);
        if(order==null) return null;   
        return orderCleaning(order);
    }

    public CustomOrder updateOrder(CustomOrderDTO ordDto) {
        log.debug("Update order "+ordDto);
        return db.updateOrder(ordDto);
    }
    
    public CustomOrder upOrderStatus(CustomOrderDTOStatus ordDto){
        log.debug("Update order status "+ordDto.status);
        if(!db.updateOrderStatus(ordDto)) return null;     
        return getOrder(ordDto.id);
    }
    

    public boolean delOrder(long id) {
        log.debug("Delete order "+id);
        return db.deleteOrder(id);
    }

    
    private CustomOrder orderCleaning(CustomOrder order){
        if(order == null) return null;
        for(int i = 0; i < order.getMenu().size(); i++){
            order.getMenu().get(i).setCusorder(new CustomOrder());
            order.getMenu().get(i).getMenuItem().setOrders(new ArrayList<CustomOrderMenu>());
            for( int j = 0; j < order.getMenu().get(i).getAdditivs().size();j++){
                order.getMenu().get(i).getAdditivs().get(j).setCom(new CustomOrderMenu());
                order.getMenu().get(i).getAdditivs().get(j).getIng().setOrders(new ArrayList<CustomOrderMenuIngredient>());
            }
        }
        return order;
    }
}
