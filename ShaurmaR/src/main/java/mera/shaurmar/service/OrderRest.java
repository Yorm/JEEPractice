
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
import mera.shaurmar.dto.CompoundOrdDTO;
import mera.shaurmar.model.CompoundOrd;
import mera.shaurmar.model.SimpleOrd;
import mera.shaurmar.dto.SimpleOrdDTO;


@Stateless
@Path("/order")
@Produces("application/json")
@Consumes("application/json") 
public class OrderRest {
    @Inject
    OrderService ordServ;
    
    @GET
    @Path("/getSim")
    public String getSimpleOrd(@QueryParam("id") long id){   
        return "Simple order ["+id+"]:" + ordServ.getSimpleOrd(id);
    }//http://localhost:8080/ShaurmaR/order/getSim?id=1
    
    @GET
    @Path("/getCom")
    public String getCompoundOrd(@QueryParam("id") long id){   
        return "Compound order ["+id+"]:" + ordServ.getCompuondOrd(id);
    }//http://localhost:8080/ShaurmaR/order/getCom?id=1
    
    @POST 
    @Path("/addSim") 
    public String addSimpleOrd(SimpleOrdDTO ordDto){    
        return ordServ.saveSimpleOrd(ordDto)+" saved";
    }/* http://localhost:8080/ShaurmaR/order/addSim
    {   
        "buyer":"user",
        "note":"поострее",
        "menuSh":[{"menuId":1,"count":"1"},{"menuId":2,"count":"1"}]
    }
    */
    
    https://dzone.com/articles/what-is-serialversionuid
    
    @POST 
    @Path("/addCom") 
    public String addCompoundOrd(CompoundOrdDTO ordDto){    
        return ordServ.saveCompoundOrd(ordDto)+" saved"; 
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
    public String delSimpleOrd(@QueryParam("id") long id){  
        return ordServ.delSimpleOrd(id)+" ";
    }//http://localhost:8080/ShaurmaR/order/delSim
    
    @DELETE
    @Path("/delCom")
    public String delCompoundOrd(@QueryParam("id") long id){  
        return ordServ.delCompoundOrd(id)+" ";
    }//http://localhost:8080/ShaurmaR/order/delCom
}
