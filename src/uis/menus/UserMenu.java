package uis.menus;

import services.EventService;
import services.ParticipantService;
import services.ReservationService;
import utils.Validator;

public class UserMenu extends Menu {

    public UserMenu(EventService eventService, ParticipantService participantService, ReservationService reservationService) {
        super(eventService, participantService, reservationService);
    }

    @Override
    public int prompt() {
        String name = reservationService.getCurrentParticipant().getName();
        System.out.println("\n##############################################################################");
        System.out.println("####                                                                      ####");
        System.out.println("####                 --  Welcome Back " + name + "  --                   ####");
        System.out.println("####                                                                      ####");
        System.out.println("##############################################################################");
        System.out.println("\nSelect an option:"
                + "\n1 - List Events"
                + "\n2 - Search Events (Title, Date, Location, Type)"
                + "\n3 - Make a reservation"
                + "\n4 - Cancel a reservation"
                + "\n5 - List Reservations"
                + "\n0 - Go Back");
        System.out.print("> ");
        return Validator.validateInteger(scanner.nextLine());
    }

    @Override
    public void choice(int option) {
        switch (option) {
            case 1:
                if(!Validator.listIsEmpty(eventService.getEvents())) eventService.listAll();
                break;
            case 2:
//                eventService.search();
                break;
            case 3:
//                reservationService.create(eventService.get());
                break;
            case 4:
                reservationService.delete();
                break;
            case 5:
                reservationService.list();
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }
}
