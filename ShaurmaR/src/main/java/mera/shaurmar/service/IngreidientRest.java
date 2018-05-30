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
    @Path("/get")
    @Produces("application/json")
    public String getIngredient(@QueryParam("id") long id){   
        return "Ingredient["+id+"]:" + ingServ.getOne(id);
    }//http://localhost:8080/ShaurmaR/ingreidient/id?id=1
    
    
    @POST 
    @Path("/addIng") 
    @Consumes("application/json") 
    public String addIngredient(Ingredient ing){
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
           System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
              System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        System.out.println(ing);
        return "sdf";
    }
    /*
    @PUT 
    @Path("/putIng") 
    @Consumes("application/json") 
    public String upIngredient(Ingredient ing){
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
           System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
              System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        System.out.println(ing);
        return "sdf";
    }
    */
    
    @DELETE
    @Path("/del")
    @Produces("application/json")
    public String delIngredient(@QueryParam("id") long id){  
        return ingServ.delOne(id)+" ";
    }//http://localhost:8080/ShaurmaR/ingreidient/del?id=31
}
/*
{
  "id":"10",
  "name":"Cheese Lavash",
  "price":"15",
  "menu":"null"
}
//Методы POST и PUT должны возвращать обратно объект, который они изменили или создали, — это позволит сократить время обращения к сервису вдвое.
//TODO Объединить ресты
POST – создать новую сущность
POST /Stations – JSON-описание сущности целиком. Действие добавляет новую сущность в коллекцию.
Возвращает созданную сущность (во-первых, чтобы не было двойных походов к серверу, во-вторых, чтобы, если это нужно, вернуть со стороны сервера параметры, которые посчитались в этом объекте и нужны вам на клиенте).


PUT — изменить сущность
PUT /Stations/12 — Изменить сущность с ID = 12. JSON, который придет в параметре, будет записан поверх.
Возвращает измененную сущность. Путь, который был применен много раз, должен приводить систему к одному и тому же состоянию.

DELETE
DELETE /Stations/12 — удалить сущность с ID = 12.



{
  meta: {
  },
  data: [{
    id: 24,
    title: 'Behavior-Driven Development',
    author: 'Viktor Farcic'
  }, {
    id: 25,
    title: 'Continuous Integration',
    author: 'Viktor Farcic'
  }]
}

*/