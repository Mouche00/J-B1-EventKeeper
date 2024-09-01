package Entities;

import java.util.List;

public class Menu {

    public void mainMenu() {
        System.out.println("\nSelect an option:"
                + "\n1 - Login as an Administrator"
                + "\n2 - Login as a User"
                + "\n0 - Exit");
        System.out.print("> ");

    }

    public void adminMenu() {
        System.out.println("\nSelect an option:"
                + "\n1 - List Events"
                + "\n2 - Create Event"
                + "\n3 - Update Event"
                + "\n4 - Delete Event"
                + "\n5 - Search Events (Title, Date, Location, Type)"
                + "\n6 - Show All Participants"
                + "\n7 - Create Participant"
                + "\n8 - Update Participant"
                + "\n9 - Delete Participant"
                + "\n0 - Go Back");
        System.out.print("> ");
    }

    public void userMenu(String name) {
        System.out.println("Welcome " + name);
        System.out.println("\nSelect an option:"
                + "\n1 - List Events"
                + "\n2 - Search Events (Title, Date, Location, Type)"
                + "\n3 - Make a reservation"
                + "\n4 - Cancel a reservation"
                + "\n5 - List Reservations"
                + "\n0 - Go Back");
        System.out.print("> ");
    }
}
