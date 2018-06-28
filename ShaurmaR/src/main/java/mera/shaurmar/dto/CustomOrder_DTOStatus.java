package mera.shaurmar.dto;

import mera.shaurmar.model.Status;


public class CustomOrder_DTOStatus {
    public long id;
    public Status status;

    public CustomOrder_DTOStatus() {
    }

    @Override
    public String toString() {
        return "CustomOrder_DTOStatus{" + "id=" + id + ", status=" + status + '}';
    }
    
}
