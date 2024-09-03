package utils.menus;

import services.EventService;
import services.ParticipantService;
import services.ReservationService;
import utils.Validator;

public class MainMenu extends Menu {

    public MainMenu(EventService eventService, ParticipantService participantService, ReservationService reservationService) {
        super(eventService, participantService, reservationService);
    }

    @Override
    public int prompt() {
        System.out.println("\nSelect an option:"
                + "\n1 - Login as an Administrator"
                + "\n2 - Login as a User"
                + "\n0 - Exit");
        System.out.print("> ");
        return Validator.validateInteger(scanner.nextLine());
    }

    @Override
    public void choice(int option) {
        switch (option) {
            case 0:
//                System.out.println("\nExiting...");
//                System.exit(0);
                break;
            case 1:
                AdminMenu adminMenu = new AdminMenu(eventService, participantService);
                adminMenu.menu();
                break;
            case 2:
                if(!participantService.getParticipants().isEmpty()) {
                    reservationService.setCurrentParticipant(participantService.get());

                    UserMenu userMenu = new UserMenu(eventService, participantService, reservationService);
                    userMenu.menu();
                } else {
                    System.out.println("\nNo participants available!\n");
                }
                break;
            default:
                System.out.println("\nInvalid option!\n");
        }
    }
}
