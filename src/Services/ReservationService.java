package Services;

import Entities.Event;
import Entities.Participant;
import Entities.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReservationService {

    Reservation currentReservation = new Reservation();
    List<Reservation> reservations = new ArrayList<>();
    List<Reservation> filteredReservations = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public String getCurrentParticipantName() {
        return currentReservation.getParticipant().getName();
    }

    public void setCurrentParticipant(Participant participant) {
        currentReservation.setParticipant(participant);
    }

    public void create(Event event) {
        // Instantiate a new Reservation object to avoid referencing the global "currentReservation" object
        Reservation reservation = new Reservation(event, currentReservation.getParticipant());
        reservations.add(reservation);
    }

    public void list() {
        filteredReservations = reservations.stream().filter(r -> r.getParticipant().getId() == currentReservation.getParticipant().getId()).collect(Collectors.toList());
        int pos = 0;
        for (Reservation reservation : filteredReservations) {
            System.out.println("\n\t#" + pos + ": "
                    + "\t" + reservation.getEvent());
            pos++;
        }
    }

    public void delete() {
        int option;
        do {
            System.out.println("Select a reservation: ");
            this.list();
            System.out.print("> ");
            option = scanner.nextInt();

            if(option < 0 || option > filteredReservations.size() - 1) {
                System.out.println("\nInvalid option!");
            }
        } while(option < 0 || option > filteredReservations.size() - 1);

        reservations.remove(filteredReservations.get(option));
    }
}
