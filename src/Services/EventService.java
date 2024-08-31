package Services;

import Models.Event;
import Models.EventType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventService {

    List<Event> events = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    int id = 0;
    String title;
    LocalDate date;
    String location;
    int option;
    EventType type;

    public void create() {
        System.out.print("\nEnter title: ");
        title = scanner.nextLine();

        System.out.print("Enter date (yyyy-mm-dd): ");
        date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter location: ");
        location = scanner.nextLine();

        System.out.println("Choose type: ");
        System.out.println("\t1 - Music");
        System.out.println("\t2 - Art");
        System.out.println("\t3 - Tech");
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

        id = events.isEmpty() ? 0 : events.getLast().getId() + 1;
        Event event = new Event(id, title, date, location, type);
        events.add(event);
    }

    public void edit() {
        if(!events.isEmpty()){
            do {
                System.out.println("Select an event");
                this.list();
                System.out.print("> ");
                option = scanner.nextInt();

                if(option < 1 || option > 3) {
                    System.out.println("\nInvalid option!");
                }
            } while(option < 0 || option > events.size());

            this.update(option);
        } else {
            System.out.println("\nNo events available!");
        }
    }

    public void update(int index) {
        Event event = events.get(index);
        System.out.print("Enter title: ");
        event.setTitle(scanner.nextLine());
    }

    public void list() {
        if(!events.isEmpty()){
            int pos = 0;
            for(Event event : events) {
                System.out.println("\n\t#" + pos + "; "
                        + "\t" + event);
                pos++;
            }
        } else {
            System.out.println("\nNo events available!");
        }
    }

}
