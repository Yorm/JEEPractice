package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.CustomOrder_Menu;
import mera.shaurmar.model.Status;

public class CustomOrder_UpdateDTO {
    public long id;
    public String buyer;
    public String note;
    public Float sum;
    public java.util.Date creationDate; 
    public Status status; 
    public List<CustomOrder_Menu> menuSh = new ArrayList<>();

    @Override
    public String toString() {
        return "CustomOrder_UpdateDTO{" + "id=" + id + ", buyer=" + buyer + ", note=" + note + ", sum=" + sum + ", creationDate=" + creationDate + ", status=" + status + ", menuSh=" + menuSh + '}';
    }
    
}
