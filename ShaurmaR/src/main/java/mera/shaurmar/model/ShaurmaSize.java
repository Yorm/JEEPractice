package mera.shaurmar.model;


public enum ShaurmaSize {
    
    STANDART("Standart size"),
    MINI("Small shaurma"), 
    VIP("V I P");
    
    private String description;

    private ShaurmaSize(String description) {
        this.description = description;
    }

    public String getDescription() {return description;}

}
