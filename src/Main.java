import Services.EventService;

import java.util.Scanner;

public class Main {
    public static int EXIT_OPTION = 0;

    public static void menu() {
        System.out.println("\nSelect an option:");
        System.out.println("1 - Login as an Administrator"
                + "\n2 - Login as a User"
                + "\n0 - Exit");
        System.out.print("> ");

    }

    public static void adminMenu() {
        System.out.println("\nSelect an option:");
        System.out.println(
                "1 - Show All Events"
                + "\n2 - Create Event"
                + "\n3 - Update Event"
                + "\n4 - Delete Event"
                + "\n5 - Search Events (Date, Location, Type)"
                + "\n9 - Logout"
                + "\n0 - Exit");
        System.out.print("> ");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {
            menu();
            option = scanner.nextInt();

            switch(option){
                case 1:
                    EventService eventService = new EventService();
                    do {
                        adminMenu();
                        option = scanner.nextInt();

                        switch(option){
                            case 1:
                                eventService.list();
                                break;
                            case 2:
                                eventService.create();
                                break;
                            case 3:
                                eventService.edit();
                                break;
                            default:
                                System.out.println("Invalid option!");
                                break;
                        }
                    } while(option != EXIT_OPTION);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while(option != EXIT_OPTION);
    }
}