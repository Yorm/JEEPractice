package mera.shaurmar.dto;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mera.shaurmar.model.CustomOrderMenu;
import mera.shaurmar.model.Status;

public class CustomOrderUpdateDTO {
    public long id;
    public String buyer;
    public String note;
    public double sum;
    public ZonedDateTime creationDate; 
    public Status status; 
    public List<CustomOrderMenu> menuSh = new ArrayList<>();

    @Override
    public String toString() {
        return "CustomOrderUpdateDTO{" + "id=" + id + ", buyer=" + buyer + ", note=" + note + ", sum=" + sum + ", creationDate=" + creationDate + ", status=" + status + ", menuSh=" + menuSh + '}';
    }

    
    
}
