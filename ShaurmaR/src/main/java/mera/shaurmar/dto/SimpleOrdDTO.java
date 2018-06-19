package mera.shaurmar.dto;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrdDTO {
    public String buyer;
    public String note;
    public List<SimpleOrd_Menu_DTO> menuSh = new ArrayList<>();
}
