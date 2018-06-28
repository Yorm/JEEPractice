
package mera.shaurmar.service;

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
import javax.ws.rs.core.Response;
import mera.shaurmar.dto.CustomOrderDTO;
import mera.shaurmar.dto.CustomOrder_DTOStatus;
import mera.shaurmar.dto.CustomOrder_UpdateDTO;


@Stateless
@Path("/order")
@Produces("application/json")
@Consumes("application/json") 
public class OrderRest {
    @Inject
    OrderService ordServ;
    
    @GET
    @Path("/getOrd")
    public String getOrder(@QueryParam("id") long id){   
        return "Order ["+id+"]:" + ordServ.getOrder(id);
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
    public String upOrder(CustomOrder_UpdateDTO ord){
        return ordServ.updateOrder(ord)+" update";
    }/* http://localhost:8080/ShaurmaR/order/putOrd
    {
    
        {   
        "id":3,
        "buyer":"user_TEST",
        "note":"hot",
        "sum":30000,
        "creationDate":"Jun 27, 2018 3:46:17 PM",
        "status":"CANCELED",
        "menuSh":[
                {
                    "id":5,
                    "menu":{"id":1,"name":"Svinnaya","price":140},
                    "count":3,
                    "shaurmaSize":"MINI",
                    "additivs":[{
                                    "comtable_id":5,
                                    "ingredientId":5,
                                    "count":1,
                                    "ing":{"id":5,"name":"Pepper","price":15}
                                },
                                {
                                    "comtable_id":5,
                                    "ingredientId":2,
                                    "count":5,
                                    "ing":{"id":2,"name":"Pork","price":50}
                                }]
                },
                {
                    "id":6,
                    "menu":{"id":2,"name":"Kyryinaya","price":120},
                    "count":50,
                    "shaurmaSize":"MINI",
                    "additivs":[{
                        "comtable_id":6,
                        "ingredientId":2,
                        "count":35,
                        "ing":{"id":1,"name":"Chiken","price":30}
                    }]
                }]
    }
    }
    */ 
    @PUT 
    @Path("/putStatusOrd") 
    public Response upOrderStatus(CustomOrder_DTOStatus ord){
        CustomOrder_DTOStatus ordStat = ordServ.upOrderStatus(ord);
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
