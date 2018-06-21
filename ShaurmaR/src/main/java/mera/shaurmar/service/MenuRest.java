
package mera.shaurmar.service;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.inject.Inject;
import mera.shaurmar.model.Menu;
import mera.shaurmar.dto.MenuDTO;

@Stateless
@Path("/menu")
@Produces("application/json")
@Consumes("application/json") 
public class MenuRest {
    @Inject
    MenuService menuServ;
    
    @GET
    @Path("/get")
    public String getMenu(@QueryParam("id") Long id){   
        return "Menu["+id+"]:" + menuServ.getMenu(id);
    }//http://localhost:8080/ShaurmaR/menu/get?id=1
    
    @DELETE
    @Path("/del")
    public String delMenu(@QueryParam("id") Long id){  
        return menuServ.delMenu(id)+" ";
    }//http://localhost:8080/ShaurmaR/menu/del?id=1
    
    @POST 
    @Path("/addMenu") 
    public String addMenu(MenuDTO shDto){    
        return menuServ.saveMenu(shDto)+" saved";
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
    public String upMenu(Menu sh){
        return menuServ.updateMenu(sh)+" update";
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
