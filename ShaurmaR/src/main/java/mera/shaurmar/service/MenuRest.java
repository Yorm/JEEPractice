
package mera.shaurmar.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import mera.shaurmar.dto.MenuDTO;
import mera.shaurmar.model.Ingredient;
import mera.shaurmar.model.Menu;

@Stateless
@Path("/menu")
@Produces("application/json")
@Consumes("application/json") 
public class MenuRest {
    @Inject
    MenuService menuServ;
    
    @GET
    @Path("/getAll")
    public Response getMenus(){ 
        ArrayList<Menu> result = menuServ.getAll();
        if(result == null) return Response.serverError().build();  
        
        GenericEntity<List<Menu>> list = new GenericEntity<List<Menu>>(result) {};
        return Response.ok(list.toString()).build();
    }//http://localhost:8080/ShaurmaR/menu/getAll
    
    @GET
    @Path("/get")
    public Response getMenu(@QueryParam("id") Long id){ 
        MenuDTO menu = menuServ.getMenu(id);
        return menu==null?Response.serverError().build():Response.ok(menu).build();
    }//http://localhost:8080/ShaurmaR/menu/get?id=1
    
    @DELETE
    @Path("/del")
    public Response delMenu(@QueryParam("id") Long id){  
        return menuServ.delMenu(id)?Response.ok().build():Response.serverError().build();
    }//http://localhost:8080/ShaurmaR/menu/del?id=1
    
    @POST 
    @Path("/addMenu") 
    public Response addMenu(MenuDTO shDto){  
        return menuServ.saveMenu(shDto)==null?Response.serverError().build():Response.ok(shDto).build(); 
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
    public Response upMenu(MenuDTO shDto){ 
        return menuServ.updateMenu(shDto)==null?Response.serverError().build():Response.ok(shDto).build();
    }/*
    http://localhost:8080/ShaurmaR/menu/putMenu
    {
        "id":100,
        "name":"TEST_ING_UPDATE",
        "price":767,
        "menu":[]
        "shaurma":[]
    }
    */
}
