package mera.shaurmar.dto;



public class CustomOrderMenuIngredientDTO {
    public long ingid;
    public long comid;
    public int count;
    public CustomOrderMenuDTO com;
    public IngredientDTO ing;   

    @Override
    public String toString() {
        return "CustomOrderMenuIngredientDTO{" + "ingid=" + ingid + ", comid=" + comid + ", count=" + count + ", com=" + com + ", ing=" + ing + '}';
    }
    
}
