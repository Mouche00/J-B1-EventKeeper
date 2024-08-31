package Services;

import Entities.Event;
import Entities.EventType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EventService {

    List<Event> events = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    int option;
    EventType type;

    public void create() {

        System.out.print("\nEnter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter date (yyyy-mm-dd): ");
        String input = scanner.nextLine();
        boolean isDate = Pattern.matches("^(\\d{4,5}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]))$", input);
        LocalDate date = isDate ? LocalDate.parse(input) : LocalDate.now();

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        System.out.println("Choose type:"
                + "\n\t1 - Music"
                + "\n\t2 - Art"
                + "\n\t3 - Tech");
        System.out.print("> ");
        option = scanner.nextInt();

        do {
            switch (option) {
                case 1:
                    type = EventType.MUSIC;
                    break;
                case 2:
                    type = EventType.ART;
                    break;
                case 3:
                    type = EventType.TECH;
                    break;
                default:
                    System.out.println("\nInvalid option");
                    System.out.print("> ");
                    break;
            }
        }while(option < 1 || option > 3);

        // Absorbs stray 'Enter' key press
        scanner.nextLine();

        int id = events.isEmpty() ? 0 : events.getLast().getId() + 1;
        Event event = new Event(id, title, date, location, type);
        events.add(event);
    }

    public Event get(){
        do {
            System.out.println("Select an event");
            this.listAll();
            System.out.print("> ");
            option = scanner.nextInt();

            if(option < 0 || option > events.size() - 1) {
                System.out.println("\nInvalid option!");
            }
        } while(option < 0 || option > events.size() - 1);

        // Absorbs stray 'Enter' key press
        scanner.nextLine();

        return events.get(option);
    }

    public void update() {
        this.isEmpty();

        Event event = this.get();

        System.out.print("Enter title: ");
        String input = scanner.nextLine();
        event.setTitle(input.isEmpty() ? event.getTitle() : input);

        System.out.print("Enter date (yyyy-mm-dd): ");
        input = scanner.nextLine();
        event.setDate(input.isEmpty() ? event.getDate() : LocalDate.parse(input));

        System.out.print("Enter location: ");
        input = scanner.nextLine();
        event.setLocation(input.isEmpty() ? event.getLocation() : input);

        System.out.println("Choose type:"
                + "\n\t1 - Music"
                + "\n\t2 - Art"
                + "\n\t3 - Tech"
                + "\n\t0 - Original Value");
        System.out.print("> ");
        option = scanner.nextInt();

        do {
            switch (option) {
                case 0:
                    break;
                case 1:
                    event.setType(EventType.MUSIC);
                    break;
                case 2:
                    event.setType(EventType.ART);
                    break;
                case 3:
                    event.setType(EventType.TECH);
                    break;
                default:
                    System.out.println("\nInvalid option");
                    System.out.print("> ");
                    break;
            }
        }while(option < 0 || option > 3);
    }

    public void delete() {
        this.isEmpty();

        Event event = this.get();
        events.remove(event);
    }

    public void search(){
        this.isEmpty();

        System.out.print("Enter a search term (Title, Date, Location, Type): ");
        String input = scanner.nextLine();

        boolean isDate = Pattern.matches("^(\\d{4,5}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]))$", input);

        List<Event> result = events.stream()
                .filter(e -> e.getTitle().contains(input)
                        || e.getDate().equals(isDate ? LocalDate.parse(input) : input)
                        || e.getLocation().contains(input)
                        || input.equalsIgnoreCase(e.getType().toString()))
                .collect(Collectors.toList());

        this.list(result);
    }

    public void list(List<Event> events) {
        this.isEmpty();

        int pos = 0;
        for(Event event : events) {
            System.out.println("\n\t#" + pos + ": "
                    + "\t" + event);
            pos++;
        }
    }

    public void listAll() {
        this.list(events);
    }

    public void isEmpty() {
        if(events.isEmpty()){
            System.out.println("\nNo events available!");
            return;
        }
    }

}
