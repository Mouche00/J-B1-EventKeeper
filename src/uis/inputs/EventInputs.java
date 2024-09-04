package uis.inputs;

import dtos.EventDTO;
import utils.Parser;
import utils.Validator;
import utils.enums.EventType;
import utils.enums.InputType;

import java.time.LocalDate;
import java.util.Scanner;

public class EventInputs {
    int option;
    EventType type = null;
    Scanner scanner = new Scanner(System.in);

    // Console inputs for event creation
    public EventDTO create() {
        String title = Validator.validateInput(
                "Enter title: ",
                InputType.STRING);

        LocalDate date = Parser.parseDate(
                Validator.validateInput(
                        "Enter date (YYYY-MM-DD):",
                        InputType.DATE));

        String location = Validator.validateInput(
                "Enter location: ",
                InputType.STRING);

        do {
            System.out.println("Choose type:"
                    + "\n\t1 - Music"
                    + "\n\t2 - Art"
                    + "\n\t3 - Tech");
            System.out.print("> ");
            option = Validator.validateInteger(scanner.nextLine());

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
                    System.out.println("\nInvalid option!\n");
                    break;
            }
        }while(option < 1 || option > 3);
        
        return new EventDTO(title, date, location, type);
    }

    // Console inputs for event update
    public EventDTO update() {
        EventDTO eventDTO = new EventDTO();

        System.out.print("Enter title: ");
        String input = scanner.nextLine();
        if(!input.isEmpty()) eventDTO.setTitle(input);

        System.out.print("Enter date (YYYY-MM-DD): ");
        input = scanner.nextLine();
        if(!input.isEmpty() && Validator.isDate(input)) eventDTO.setDate(Parser.parseDate(input));

        System.out.print("Enter location: ");
        input = scanner.nextLine();
        if(!input.isEmpty()) eventDTO.setLocation(input);

        do {
            System.out.println("Choose type:"
                    + "\n\t1 - Music"
                    + "\n\t2 - Art"
                    + "\n\t3 - Tech"
                    + "\n\t0 - Original Value");
            System.out.print("> ");
            option = Validator.validateInteger(scanner.nextLine());

            switch (option) {
                case 0:
                    break;
                case 1:
                    eventDTO.setType(EventType.MUSIC);
                    break;
                case 2:
                    eventDTO.setType(EventType.ART);
                    break;
                case 3:
                    eventDTO.setType(EventType.TECH);
                    break;
                default:
                    System.out.println("\nInvalid option");
                    break;
            }
        }while(option < 0 || option > 3);
        return eventDTO;
    }

    // Console input for selection from a list
    public int getIndex(int listSize) {
        return Parser.parseInt(
                Validator.validateInput("> ", InputType.OPTION, 0, listSize));
    }

    // Console input for search string
    public String search(){
        return Validator.validateInput("Enter a search term (Title, Date, Location, Type): ", InputType.STRING);
    }
}
