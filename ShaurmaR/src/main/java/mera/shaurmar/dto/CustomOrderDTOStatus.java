package mera.shaurmar.dto;

import javax.validation.constraints.NotNull;
import mera.shaurmar.model.Status;


public class CustomOrderDTOStatus {
    @NotNull
    public long id;
    @NotNull
    public Status status;

    public CustomOrderDTOStatus() {
    }

    @Override
    public String toString() {
        return "CustomOrderDTOStatus{" + "id=" + id + ", status=" + status + '}';
    }
    
}
