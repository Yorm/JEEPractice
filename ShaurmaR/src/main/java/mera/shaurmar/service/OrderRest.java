
package mera.shaurmar.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import mera.shaurmar.dto.CustomOrderDTO;
import mera.shaurmar.dto.CustomOrderDTOStatus;
import mera.shaurmar.dto.CustomOrderUpdateDTO;
import mera.shaurmar.model.CustomOrder;
import mera.shaurmar.model.Menu;


@Stateless
@Path("/order")
@Produces("application/json")
@Consumes("application/json") 
public class OrderRest {
    @Inject
    OrderService ordServ;
    
    @GET
    @Path("/getAll")
    public Response getOrders(){ 
        ArrayList<CustomOrder> result = ordServ.getAll();
        if(result == null) return Response.serverError().build();  
        
        GenericEntity<List<CustomOrder>> list = new GenericEntity<List<CustomOrder>>(result) {};
        return Response.ok(list.toString()).build();
    }//http://localhost:8080/ShaurmaR/order/getAll
    
    @GET
    @Path("/getOrd")
    public Response getOrder(@QueryParam("id") long id){   
        CustomOrderUpdateDTO ord = ordServ.getOrder(id);
        return ord==null?Response.serverError().build():Response.ok(ord).build();
    }//http://localhost:8080/ShaurmaR/order/getOrd?id=1 
    
    @POST 
    @Path("/addOrd") 
    public Response addOrder(CustomOrderDTO ordDto){    
        return ordServ.saveOrder(ordDto)==null?Response.serverError().build():Response.ok(ordDto).build();
    }/* http://localhost:8080/ShaurmaR/order/addOrd
    
    {   
        "buyer":"user",
        "note":"hot",
        "menuSh":[
                {
                    "menu":{"id":1},
                    "count":3,
                    "shaurmaSize":"MINI",
                    "additivs":[{
                                    "count":1,
                                    "ing":{"id":5}
                                },
                                {
                                    "count":5,
                                    "ing":{"id":2}
                                }]
                },
                {
                    "menu":{"id":2},
                    "count":1,
                    "shaurmaSize":"VIP",
                    "additivs":[{
                        "count":35,
                        "ing":{"id":1}
                    }]
                }]
    }
    */
 
    //TODO
    @PUT 
    @Path("/putOrd") 
    public String upOrder(CustomOrderDTO ord){
        CustomOrder order = ordServ.updateOrder(ord);
        return order+" ";
    }/* http://localhost:8080/ShaurmaR/order/putOrd
     {   
      "id":56,
      "note":"hot",
      "status":"CANCELED",
      "menuSh":[
                {
                  "menu":{"id":3},
                  "count":1,
                  "shaurmaSize":"STANDART",
                  "additivs":[{
                                    "ingid":5,
                                    "count":1
                                },
                                {
                                    "ingid":2,
                                    "count":5
                                }]
                },
                {
                  "menu":{"id":2},
                  "count":1,
                  "shaurmaSize":"STANDART",
                  "additivs":[{
                                "ingid":1,
                                "count":35
                  }]
                },
        		{
                  "menu":{"id":4},
                  "count":440,
                  "shaurmaSize":"STANDART",
                  "additivs":[]
                }
    
              ]
    }
    
    */ 
    @PUT 
    @Path("/putStatusOrd") 
    public Response upOrderStatus(CustomOrderDTOStatus ord){
        CustomOrderDTOStatus ordStat = ordServ.upOrderStatus(ord);
        return ordStat==null?Response.serverError().build():Response.ok(ordStat).build();
    }// http://localhost:8080/ShaurmaR/order/putStatusOrd
    /*
    {
        "id":3,
        "status":"READY"
    }
    */

    @DELETE
    @Path("/delOrd")
    public Response delOrder(@QueryParam("id") long id){  
        return ordServ.delOrder(id)?Response.ok().build():Response.serverError().build();
    }//http://localhost:8080/ShaurmaR/order/delOrd?id=59 
    
}
