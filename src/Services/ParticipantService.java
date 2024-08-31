package Services;

import Entities.Event;
import Entities.EventType;
import Entities.Participant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ParticipantService {

    List<Participant> participants = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void create() {

        System.out.print("\nEnter name: ");
        String name = scanner.nextLine();

        // Absorbs stray 'Enter' key press
        scanner.nextLine();

        int id = participants.isEmpty() ? 0 : participants.getLast().getId() + 1;
        Participant participant = new Participant(id, name);
        participants.add(participant);
    }
}
