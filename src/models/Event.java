package models;

import utils.enums.EventType;

import java.time.LocalDate;

public class Event {

    private int id;
    private String title;
    private LocalDate date;
    private String location;
    private EventType type;

    private static int counter = 0;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public EventType getType(){
        return this.type;
    }

    public void setType(EventType type){
        this.type = type;
    }

    public Event(String title, LocalDate date, String location, EventType type){
        this.id = counter++;
        this.title = title;
        this.date = date;
        this.location = location;
        this.type = type;
    }

    @Override
    public String toString(){
        return "\n\tId: " + this.id
                + "\n\tTitle: " + this.title
                + "\n\tDate: " + this.date
                + "\n\tLocation: " + this.location
                + "\n\tType: " + this.type;
    }
}
