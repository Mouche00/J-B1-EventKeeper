import Entities.Menu;
import Services.EventService;
import Services.ParticipantService;

import java.util.Scanner;

public class Main {
    public static int EXIT_OPTION = 0;

    public static void main(String[] args) {

        Menu menu = new Menu();
        EventService eventService = new EventService();
        ParticipantService participantService = new ParticipantService();
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {
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
                                participantService.create();
                                break;
                            default:
                                System.out.println("Invalid option!");
                                break;
                        }
                    } while(option != EXIT_OPTION);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while(option != EXIT_OPTION);
    }
}