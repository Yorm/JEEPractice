
package mera.shaurmar.dto;

import java.util.ArrayList;
import mera.shaurmar.model.Ingredient;


public class  ArrayListDTO<T> {
    public ArrayList<T> array = new ArrayList();

    public ArrayListDTO() {
    }

    public ArrayListDTO(ArrayList<T> array) {
        this.array=array;
    }

    @Override
    public String toString() {
        return "ArrayListDTO{" + "\"array\"=" + array + '}';
    }
  
}
