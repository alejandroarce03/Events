package model;
public class Auditorium{
    //atributtes
    private String name;
    private String location;
    private String status;
    private Chair[][] chairs;
    private String[] alphabet;
    //methods
    public Auditorium(String name, String location,String status,Chair[][] chairs,String[] alphabet){
        this.name = name;
        this.location = location;
        this.status = status;
        this.chairs = chairs;
        this.alphabet = alphabet;
    }
    public String getName() 
    {
        return this.name;
    }

    public String getLocation() 
    {
        return this.location;
    }

    public String getStatus() 
    {
        return this.status;
    }

    public Chair[][] getChairs() 
    {
        return this.chairs;
    }
    public String[] getAlphabet(){
        return this.alphabet;
    }
}