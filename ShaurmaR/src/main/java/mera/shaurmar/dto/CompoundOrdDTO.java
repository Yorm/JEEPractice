
package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompoundOrdDTO {
    public List<CompoundOrd_Ingredient_DTO> ingredients = new ArrayList<>();
    public String buyer;
    public String note;
}
