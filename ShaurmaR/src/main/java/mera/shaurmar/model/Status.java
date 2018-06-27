package mera.shaurmar.model;

public enum Status{
    CANCELED("Canceled"),
    NEW("New order created"),
    INPROGRESS("Order in progress"), 
    READY("Order ready"), 
    DELIVERED("Order delivered");
    
    private String description;

    private Status(String description) {
        this.description = description;
    }

    public String getDescription() {return description;}
}
