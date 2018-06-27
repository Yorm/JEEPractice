
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
import mera.shaurmar.model.CustomOrder;
import mera.shaurmar.dto.CustomOrderDTO;
import mera.shaurmar.dto.CustomOrder_DTOStatus;


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
    public String addOrder(CustomOrderDTO ordDto){    
        return ordServ.saveOrder(ordDto)+" saved";
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
 
    @PUT 
    @Path("/putOrd") 
    public String upOrder(CustomOrderDTO ord){
        return ordServ.upOrder(ord)+" update";
    }/* http://localhost:8080/ShaurmaR/order/putOrd
    {

    }
    */ 
    @PUT 
    @Path("/putStatusOrd") 
    public String upOrderStatus(CustomOrder_DTOStatus ord){
        return ordServ.upOrderStatus(ord)+" update";
    }// http://localhost:8080/ShaurmaR/order/putStatusOrd
    /*
    {
        "id":3,
        "status":"READY"
    }
    */

    @DELETE
    @Path("/delOrd")
    public String delOrder(@QueryParam("id") long id){  
        return ordServ.delOrder(id)+" ";
    }//http://localhost:8080/ShaurmaR/order/delOrd
    
}
