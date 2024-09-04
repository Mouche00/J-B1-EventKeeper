package uis.menus;

import services.EventService;
import services.ParticipantService;
import services.ReservationService;

import java.util.Scanner;

abstract public class Menu {
    protected final int EXIT_OPTION = 0;

    protected Scanner scanner = new Scanner(System.in);
    protected EventService eventService;
    protected ParticipantService participantService;
    protected ReservationService reservationService;

    public Menu(EventService eventService, ParticipantService participantService, ReservationService reservationService) {
        this.eventService = eventService;
        this.participantService = participantService;
        this.reservationService = reservationService;
    }

    public Menu(EventService eventService, ParticipantService participantService) {
        this.eventService = eventService;
        this.participantService = participantService;
    }

    abstract int prompt();
    abstract void choice(int option);
    public void menu(){
        int option;
        do {
            option = prompt();
            choice(option);
        } while(option != EXIT_OPTION);
    }

//    public void mainMenuPrompt() {
//        System.out.println("\nSelect an option:"
//                + "\n1 - Login as an Administrator"
//                + "\n2 - Login as a User"
//                + "\n0 - Exit");
//        System.out.print("> ");
//    }

//    public void mainMenuOption(int option) {
//        switch(option){
//            case 0:
//                System.out.println("\nExiting...");
//                System.exit(0);
//                break;
//            case 1:
//                break;
//            case 2:
//                break;
//            default:
//                break;
//        }
//    }

//    public void adminMenu() {
//        System.out.println("Welcome admin"
//                + "\nSelect an option:"
//                + "\n1 - List Events"
//                + "\n2 - Create Event"
//                + "\n3 - Update Event"
//                + "\n4 - Delete Event"
//                + "\n5 - Search Events (Title, Date, Location, Type)"
//                + "\n6 - Show All Participants"
//                + "\n7 - Create Participant"
//                + "\n8 - Update Participant"
//                + "\n9 - Delete Participant"
//                + "\n0 - Go Back");
//        System.out.print("> ");
//    }

//    public void userMenu(String name) {
//        System.out.println("Welcome " + name
//                + "\nSelect an option:"
//                + "\n1 - List Events"
//                + "\n2 - Search Events (Title, Date, Location, Type)"
//                + "\n3 - Make a reservation"
//                + "\n4 - Cancel a reservation"
//                + "\n5 - List Reservations"
//                + "\n0 - Go Back");
//        System.out.print("> ");
//    }
}
