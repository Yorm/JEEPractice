package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.CustomOrder_Menu;
import mera.shaurmar.model.Status;

public class CustomOrderDTO {
    public long id;
    public String buyer;
    public String note;
    public Float sum;
    public java.util.Date creationDate; 
    public Status status; 
    public List<CustomOrder_Menu_DTO> menuSh = new ArrayList<>();

    @Override
    public String toString() {
        return "CustomOrderDTO{" + "id=" + id + ", buyer=" + buyer + ", note=" + note + ", sum=" + sum + ", creationDate=" + creationDate + ", status=" + status + ", menuSh=" + menuSh + '}';
    }

    
   
}
