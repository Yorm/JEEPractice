
package mera.shaurmar.service;

import javax.ejb.Stateless;
import javax.ws.rs.*;

import javax.ws.rs.Path;
import javax.inject.Inject;
import mera.shaurmar.model.Menu;

@Stateless
@Path("/menu")
public class MenuRest {
    @Inject
    MenuService menuServ;
    
    @GET
    @Path("/get")
    @Produces("application/json")
    public String getMenu(@QueryParam("id") long id){   
        return "Menu["+id+"]:" + menuServ.getOne(id);
    }//http://localhost:8080/ShaurmaR/menu/get?id=1
    
    @DELETE
    @Path("/del")
    @Produces("application/json")
    public String delMenu(@QueryParam("id") long id){  
        return menuServ.delOne(id)+" ";
    }//http://localhost:8080/ShaurmaR/menu/del?id=31
    
    @POST 
    @Path("/addMenu") 
    @Consumes("application/json") 
    public String addMenu(Menu sh){    
        return menuServ.saveOne(sh)+" saved";
    }/* 
    http://localhost:8080/ShaurmaR/menu/addMenu
    {
        "id":100,
        "name":"TEST_ING",
        "price":767,
        "menu":[]
        "shaurma":[]
    }
    */
    
    @PUT 
    @Path("/putMenu") 
    @Consumes("application/json") 
    public String upMenu(Menu sh){
        return menuServ.updateOne(sh)+" update";
    }/*
    http://localhost:8080/ShaurmaR/menu/putIng
    {
        "id":100,
        "name":"TEST_ING_UPDATE",
        "price":767,
        "menu":[]
        "shaurma":[]
    }
    */
}
