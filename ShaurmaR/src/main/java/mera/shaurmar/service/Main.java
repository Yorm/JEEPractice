package mera.shaurmar.service;

import mera.shaurmar.dao.DBService;
import mera.shaurmar.model.Ingredient;
import mera.shaurmar.model.Menu;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Main {

    static Logger log = Logger.getLogger(Main.class.getName());
    
    public static void hmain(String[] args) {
        log.info("\nSTART SHAURMAR\n"+
                "AEsir nornir\n" +
                "visa vanir\n" +
                "thursamoyir\n" +
                "thra valkyrjur\n" +
                "alvar dvergar\n" +
                "disir volvur\n" +
                "vordar vergar\n" +
                "Yggdrasil\n");
        
        Ingredient lav = new Ingredient("Lavash",5);
        Ingredient lavCh = new Ingredient("Cheese Lavash",15);
        Ingredient chik = new Ingredient("Chicken",30);
        Ingredient shrimp = new Ingredient("Shrimp",50);
        Ingredient pork = new Ingredient("Pork",40);
        Ingredient sausage = new Ingredient("Sausage",5);
        Ingredient carrot = new Ingredient("Korean carrot",20);
        Ingredient tmtoes = new Ingredient("Tomatoes",10);
        Ingredient cucum = new Ingredient("Cucumbers",10);
        Ingredient cucumSal = new Ingredient("Salted Cucumbers",15);
        Ingredient salad = new Ingredient("Salad",10);
        Ingredient feta = new Ingredient("Cheese \"Feta\"",10);
        Ingredient astoria = new Ingredient("Astoria Sauce",25);
        Ingredient thIslands = new Ingredient("Sauce \"Thousand Islands\"",20);
        Ingredient usual = new Ingredient("Usual sauce (ketchup, mayonnaise, salt)",5);
        Ingredient hot = new Ingredient("Hot Sauce",15);
        Ingredient sourCream = new Ingredient("Sour cream sauce (sour cream, greens)",15);
        Ingredient pepper = new Ingredient("Pepper ground, black",2);
        
        DBService db = new DBService();
        
        Menu classicSh = new Menu("Classic",140);
        classicSh.addIngOfSet(lav);
        classicSh.addIngOfSet(pork);
        classicSh.addIngOfSet(carrot);
        classicSh.addIngOfSet(tmtoes);
        classicSh.addIngOfSet(cucum);
        classicSh.addIngOfSet(salad);
        classicSh.addIngOfSet(usual);
        classicSh.addIngOfSet(hot);
        classicSh.addIngOfSet(pepper);
        
        Menu chikenSh = new Menu("Chiken",130);
        chikenSh.addIngOfSet(lavCh);
        chikenSh.addIngOfSet(chik);
        chikenSh.addIngOfSet(carrot);
        chikenSh.addIngOfSet(tmtoes);
        chikenSh.addIngOfSet(salad);
        chikenSh.addIngOfSet(astoria);
        chikenSh.addIngOfSet(pepper);
        
        Menu shrimpSh = new Menu("Shrimp",180);
        shrimpSh.addIngOfSet(lav);
        shrimpSh.addIngOfSet(shrimp);
        shrimpSh.addIngOfSet(tmtoes);
        shrimpSh.addIngOfSet(cucum);
        shrimpSh.addIngOfSet(salad);
        shrimpSh.addIngOfSet(feta);
        shrimpSh.addIngOfSet(thIslands);
        
        Menu hotdog = new Menu("HotDog",70);
        hotdog.addIngOfSet(lav);
        hotdog.addIngOfSet(sausage);
        hotdog.addIngOfSet(tmtoes);
        hotdog.addIngOfSet(cucumSal);
        hotdog.addIngOfSet(sourCream);
        hotdog.addIngOfSet(hot);
        hotdog.addIngOfSet(thIslands);
        hotdog.addIngOfSet(pepper);
        
        //db.saveObj(classicSh);
        //db.saveObj(chikenSh);
        //db.saveObj(shrimpSh);
        //db.saveObj(hotdog);
         
    }
}

