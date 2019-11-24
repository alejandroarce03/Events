package model;
import java.util.*;
import java.time.*;
public class Event{
    //atributtes
    private String name;
    private String date;
    private String timeEnd;
    private String nameTeacher;
    private String faculty;
    private int people;
    private ArrayList<Auditorium> auditors;
    private LocalDateTime dateEvent;
    private LocalDateTime timeEndEvent ;
    //methods
    public Event(String name, String date,String timeEnd,String nameTeacher, String faculty,int people,
            ArrayList<Auditorium> auditors, LocalDateTime dateEvent, LocalDateTime timeEvent) {
        this.name = name;
        this.date = date;
        this.dateEvent = dateEvent;
        this.dateEvent = LocalDateTime.parse(date);
        this.timeEnd = timeEnd;
        this.timeEndEvent = timeEndEvent;
        this.timeEndEvent = LocalDateTime.parse(timeEnd);
        this.nameTeacher = nameTeacher;
        this.faculty = faculty;
        this.people = people;
        this.auditors = new ArrayList<Auditorium>();
        this.auditors = auditors;
    }

    public String getName() 
    {
        return this.name;
    }

    public LocalDateTime getDate() 
    {
        return dateEvent;
    }

    public LocalDateTime getTimeEnd() 
    {
        return this.timeEndEvent;
    }

    public String getNameTeacher() 
    {
        return this.nameTeacher;
    }

    public String getFaculty() 
    {
        return this.faculty;
    }

    public int getPeople() 
    {
        return this.people;
    }

    public ArrayList<Auditorium> getAuditors() 
    {
        return this.auditors;
    }
  
}