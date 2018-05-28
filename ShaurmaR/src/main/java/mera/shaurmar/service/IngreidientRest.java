package mera.shaurmar.service;

import javax.ejb.Stateless;
import javax.ws.rs.*;

import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import mera.shaurmar.model.Ingredient;

@Stateless
@Path("/ingreidient")
public class IngreidientRest {
    
    @Inject
    IngredientService ingServ;
    
    @GET
    @Path("/{id}")
    //@Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public String getIngredient(@PathParam("id") long id){   
        return "Ingredient["+id+"]:" + ingServ.getOne(id);
    }
    //CRUD
    //http://qaru.site/questions/135925/how-to-return-a-partial-json-response-using-java
}
