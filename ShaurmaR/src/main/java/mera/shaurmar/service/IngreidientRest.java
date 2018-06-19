package mera.shaurmar.service;

import javax.ejb.Stateless;
import javax.ws.rs.*;

import javax.ws.rs.Path;
import javax.inject.Inject;
import mera.shaurmar.dto.IngredientDTO;
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
    public String getIngredient(@QueryParam("id") long id){   
        return "Ingredient["+id+"]:" + ingServ.getIng(id);
    }//http://localhost:8080/ShaurmaR/ingreidient/get?id=1
    
    @POST 
    @Path("/addIng") 
    public String addIngredient(IngredientDTO ingDto){    
        return ingServ.saveIng(ingDto)+" saved";
    }/* 
    http://localhost:8080/ShaurmaR/ingreidient/addIng
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
    public String upIngredient(Ingredient ing){
        return ingServ.updateIng(ing)+" update";
    }/*
    http://localhost:8080/ShaurmaR/ingreidient/putIng
    {
        "id":100,
        "name":"TEST_ING_UPDATE",
        "price":767,
        "menu":[],
        "shaurma":[]
    }
    */
    
    
    @DELETE
    @Path("/del")
    public String delIngredient(@QueryParam("id") long id){  
        return ingServ.delIng(id)+" ";
    }//http://localhost:8080/ShaurmaR/ingreidient/del?id=31
}
/*

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