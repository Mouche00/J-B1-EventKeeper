package services;

import dtos.EventDTO;
import models.Event;
import utils.Parser;
import utils.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventService {

    List<Event> events = new ArrayList<>();

    public void create(EventDTO eventDTO) {

        Event event = new Event(eventDTO.getTitle(), eventDTO.getDate(), eventDTO.getLocation(), eventDTO.getType());
        events.add(event);
    }

    public Event get(int index){

        return events.get(index);
    }

    public void update(int index, EventDTO eventDTO) {

        Event event = this.get(index);
        if(eventDTO.getTitle() != null) {
            event.setTitle(eventDTO.getTitle());
        }

        if(eventDTO.getDate() != null) {
            event.setDate(eventDTO.getDate());
        }

        if(eventDTO.getLocation() != null) {
            event.setLocation(eventDTO.getLocation());
        }

        if(eventDTO.getType() != null) {
            event.setType(eventDTO.getType());
        }

    }

    public void delete(int index) {

        Event event = this.get(index);
        events.remove(event);
    }

    public void search(String input){

        List<Event> result = events.stream()
                .filter(e -> e.getTitle().contains(input)
                        || e.getDate().equals(Validator.isDate(input) ? Parser.parseDate(input) : null)
                        || e.getLocation().contains(input)
                        || input.equalsIgnoreCase(e.getType().toString()))
                .collect(Collectors.toList());

        System.out.println("\n####");
        System.out.println("######## Search Results: ");
        System.out.println("####");
        this.list(result);
    }

    public void list(List<Event> events) {
        Validator.listIsEmpty(events);

        int pos = 0;
        for(Event event : events) {
            System.out.println("\n#" + pos++ + ": "
                    + "\t" + event);
        }
    }

    public void listAll() {
        System.out.println("\n####");
        System.out.println("######## Event List: ");
        System.out.println("####");
        this.list(events);
    }

    public List<Event> getEvents() {
        return events;
    }

}
