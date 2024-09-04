package dtos;

import utils.enums.EventType;

import java.time.LocalDate;

public class EventDTO {

    private String title;
    private LocalDate date;
    private String location;
    private EventType type;

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


    public EventDTO(String title, LocalDate date, String location, EventType type) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.type = type;
    }

    public EventDTO() {}

    @Override
    public String toString() {
        return "EventDTO{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", type=" + type +
                '}';
    }
}
