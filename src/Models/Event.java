package Models;

import java.time.LocalDate;

public class Event {

    private int id;
    private String title;
    private LocalDate date;
    private String location;
    private EventType type;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String title(){
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

    public Event(int id, String title, LocalDate date, String location, EventType type){
        this.id = id;
        this.title = title;
        this.date = date;
        this.location = location;
        this.type = type;
    }

    @Override
    public String toString(){
        return "id: " + this.id
                + "\n\tTitle: " + this.title
                + "\n\tDate: " + this.date
                + "\n\tLocation: " + this.location
                + "\n\tType: " + this.type;
    }
}
