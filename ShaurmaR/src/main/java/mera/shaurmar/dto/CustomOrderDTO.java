package mera.shaurmar.dto;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import mera.shaurmar.model.Status;

public class CustomOrderDTO {
    
    public Long id;
    
    //@NotNull
    public String buyer;
    //@NotNull
    public String note;
    
    public double sum;  
    public ZonedDateTime creationDate; 
    public Status status; 
    
    //@NotNull
    public List<CustomOrderMenuDTO> menuSh = new ArrayList<>();

    @Override
    public String toString() {
        return "CustomOrderDTO{" + "id=" + id + ", buyer=" + buyer + ", note=" + note + ", sum=" + sum + ", creationDate=" + creationDate + ", status=" + status + ", menuSh=" + menuSh + '}';
    }

    
   
}
