package mera.shaurmar.service;

import javax.ejb.Stateless;
import javax.ws.rs.*;

import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import mera.shaurmar.dto.IngredientDTO;
import mera.shaurmar.dto.MenuDTO;
import mera.shaurmar.model.Ingredient;

@Stateless
@Path("/ingreidient")
@Produces("application/json")
@Consumes("application/json") 
public class IngreidientRest {
    @Inject
    IngredientService ingServ;
    
    
    @GET
    @Path("/get")
    public Response getIngredient(@QueryParam("id") long id){   
        IngredientDTO ing = ingServ.getIng(id);
        return ing==null?Response.serverError().build():Response.ok(ing).build();
    }//http://localhost:8080/ShaurmaR/ingreidient/get?id=1 
    
    @DELETE
    @Path("/del")
    public Response delIngredient(@QueryParam("id") long id){  
        return ingServ.delIng(id)?Response.ok().build():Response.serverError().build();
    }//http://localhost:8080/ShaurmaR/ingreidient/del?id=1
    
    

    @POST 
    @Path("/addIng") 
    public Response addIngredient(IngredientDTO ingDto){    
        return ingServ.saveIng(ingDto)==null?Response.serverError().build():Response.ok(ingDto).build();
    }/* http://localhost:8080/ShaurmaR/ingreidient/addIng
        {
            "id":100,
            "name":"TEST_ING",
            "price":767,
            "menu":null,
            "shaurma":null
        }
    */
    
    @PUT 
    @Path("/putIng") 
    public Response upIngredient(IngredientDTO ingDto){
        return ingServ.updateIng(ingDto)==null?Response.serverError().build():Response.ok(ingDto).build();
    }/*http://localhost:8080/ShaurmaR/ingreidient/putIng
        {
            "id":100,
            "name":"TEST_ING_UPDATE",
            "price":767,
            "menu":[],
            "shaurma":[]
        }
    */
    
    

}
