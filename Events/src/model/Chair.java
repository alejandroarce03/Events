package model;
public class Chair{
    //constants
    public static final String OPERATIONAL ="OPERATIONAL";
    public static final String FAULTY = "FAULTY";
    //atributtes
    private String status;
    private String description;
    //methods
    public Chair(String status,String description){
        this.status = status;
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }
    public void setDescription(String description){
        this.description = description;
    }
}