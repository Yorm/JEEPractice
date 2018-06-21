package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;
import mera.shaurmar.model.Status;

public class SimpleOrdDTO {
    public Float id;
    public String buyer;
    public String note;
    public Float price;
    public Status status;
    public List<SimpleOrd_Menu_DTO> menuSh = new ArrayList<>();
    
}
