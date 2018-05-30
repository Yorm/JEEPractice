
package mera.shaurmar.service;

import javax.ejb.Stateless;
import javax.ws.rs.*;

import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import mera.shaurmar.model.Ingredient;

@Stateless
@Path("/menu")
public class MenuRest {
    @Inject
    MenuService menuServ;
    
    @GET
    @Path("/get")
    @Produces("application/json")
    public String getIngredient(@QueryParam("id") long id){   
        return "Ingredient["+id+"]:" + menuServ.getOne(id);
    }//http://localhost:8080/ShaurmaR/ingreidient/id?id=1
    
    @DELETE
    @Path("/del")
    @Produces("application/json")
    public String delIngredient(@QueryParam("id") long id){  
        return menuServ.delOne(id)+" ";
    }//http://localhost:8080/ShaurmaR/ingreidient/del?id=31
}
