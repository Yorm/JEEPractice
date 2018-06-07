
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
import mera.shaurmar.model.CompoundOrd;
import mera.shaurmar.model.Ingredient;
import mera.shaurmar.model.SimpleOrd;

@Stateless
@Path("/order")
public class OrderRest {
    @Inject
    OrderService ordServ;
    
    @GET
    @Path("/getSim")
    @Produces("application/json")
    public String getSimpleOrd(@QueryParam("id") long id){   
        return "Simple order ["+id+"]:" + ordServ.getSimpleOrd(id);
    }//http://localhost:8080/ShaurmaR/order/getSim?id=1
    @GET
    @Path("/getCom")
    @Produces("application/json")
    public String getCompoundOrd(@QueryParam("id") long id){   
        return "Compound order ["+id+"]:" + ordServ.getCompuondOrd(id);
    }//http://localhost:8080/ShaurmaR/order/getCom?id=1
    
    @POST 
    @Path("/addSim") 
    @Consumes("application/json") 
    public String addSimpleOrd(SimpleOrd ord){    
        return ordServ.saveSimpleOrd(ord)+" saved";
    }/* http://localhost:8080/ShaurmaR/order/addSim
    {
        "id":100,
        "name":"TEST_ING",
        "price":767,
        "menu":[]
        "shaurma":[]
    }
    */
    @POST 
    @Path("/addCom") 
    @Consumes("application/json") 
    public String addCompoundOrd(CompoundOrd ord){    
        return ordServ.saveCompoundOrd(ord)+" saved";
    }/* http://localhost:8080/ShaurmaR/order/addCom
    {
        "id":100,
        "name":"TEST_ING",
        "price":767,
        "menu":[]
        "shaurma":[]
    }
    */
    
    @PUT 
    @Path("/putSim") 
    @Consumes("application/json") 
    public String upSimpleOrd(SimpleOrd ord){
        return ordServ.upSimpleOrd(ord)+" update";
    }/* http://localhost:8080/ShaurmaR/order/putSim
    {
        "id":100,
        "name":"TEST_ING_UPDATE",
        "price":767,
        "menu":[]
        "shaurma":[]
    }
    */
    @PUT 
    @Path("/putCom") 
    @Consumes("application/json") 
    public String upCompoundOrd(CompoundOrd ord){
        return ordServ.upCompoundOrd(ord)+" update";
    }/*http://localhost:8080/ShaurmaR/order/putCom
    {
        "id":100,
        "name":"TEST_ING_UPDATE",
        "price":767,
        "menu":[]
        "shaurma":[]
    }
    */

    @DELETE
    @Path("/delSim")
    @Produces("application/json")
    public String delSimpleOrd(@QueryParam("id") long id){  
        return ordServ.delSimpleOrd(id)+" ";
    }//http://localhost:8080/ShaurmaR/order/delSim
    @DELETE
    @Path("/delCom")
    @Produces("application/json")
    public String delCompoundOrd(@QueryParam("id") long id){  
        return ordServ.delCompoundOrd(id)+" ";
    }//http://localhost:8080/ShaurmaR/order/delCom
}
