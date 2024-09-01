import Entities.Menu;
import Entities.Participant;
import Entities.Reservation;
import Services.EventService;
import Services.ParticipantService;
import Services.ReservationService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static int EXIT_OPTION = 0;

    public static void main(String[] args) {

        Menu menu = new Menu();
        EventService eventService = new EventService();
        ParticipantService participantService = new ParticipantService();
        ReservationService reservationService = new ReservationService();
        Scanner scanner = new Scanner(System.in);
        int option;

        while(true) {
            menu.mainMenu();
            option = scanner.nextInt();

            switch(option){
                case 1:
                    do {
                        menu.adminMenu();
                        option = scanner.nextInt();

                        switch(option){
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
                                System.out.println("Invalid option!");
                                break;
                        }
                    } while(option != EXIT_OPTION);
                    break;
                case 2:
                    if(participantService.getParticipants().size() > 0) {
                        do {
                            participantService.list();
                            option = scanner.nextInt();
                        } while (option < 0 || option > participantService.getParticipants().size() - 1);

                        reservationService.setCurrentParticipant(participantService.getParticipant(option));
                        do {

                            menu.userMenu(reservationService.getCurrentParticipantName());
                            option = scanner.nextInt();

                            switch (option) {
                                case 1:
                                    eventService.listAll();
                                    break;
                                case 2:
                                    eventService.search();
                                    break;
                                case 3:
                                    reservationService.create(eventService.get());
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
                        } while (option != EXIT_OPTION);
                    } else {
                        System.out.println("No participants available!");
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}