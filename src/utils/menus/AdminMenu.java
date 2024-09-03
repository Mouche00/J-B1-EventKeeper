package utils.menus;

import models.Event;
import models.Participant;
import services.EventService;
import services.ParticipantService;
import services.ReservationService;
import utils.Validator;

import java.util.List;

public class AdminMenu extends Menu {

    public AdminMenu(EventService eventService, ParticipantService participantService) {
        super(eventService, participantService);
    }

    @Override
    public int prompt() {
        System.out.println("\nWelcome admin"
                + "\nSelect an option:"
                + "\n1 - List Events"
                + "\n2 - Create Event"
                + "\n3 - Update Event"
                + "\n4 - Delete Event"
                + "\n5 - Search Events (Title, Date, Location, Type)"
                + "\n6 - List Participants"
                + "\n7 - Create Participant"
                + "\n8 - Update Participant"
                + "\n9 - Delete Participant"
                + "\n0 - Go Back");
        System.out.print("> ");
        return Validator.validateInteger(scanner.nextLine());
    }

    @Override
    public void choice(int option) {
        switch(option){
            case 0:
                break;
            case 1:
                eventService.listAll();
                break;
            case 2:
                eventService.create();
                break;
            case 3:
                eventService.update();
                break;
            case 4:
                eventService.delete();
                break;
            case 5:
                eventService.search();
                break;
            case 6:
                participantService.list();
                break;
            case 7:
                participantService.create();
                break;
            case 8:
                participantService.update();
                break;
            case 9:
                participantService.delete();
                break;
            default:
                System.out.println("\nInvalid option!\n");
                break;
        }
    }
}
