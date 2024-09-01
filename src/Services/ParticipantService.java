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
    int option;

    public void create() {

        System.out.print("\nEnter name: ");
        String name = scanner.nextLine();

        int id = participants.isEmpty() ? 0 : participants.getLast().getId() + 1;
        Participant participant = new Participant(id, name);
        participants.add(participant);
    }

    public Participant get(){
        do {
            System.out.println("Select a participant");
            this.list();
            System.out.print("> ");
            option = scanner.nextInt();

            if(option < 0 || option > participants.size() - 1) {
                System.out.println("\nInvalid option!");
            }
        } while(option < 0 || option > participants.size() - 1);

        // Absorbs stray 'Enter' key press
        scanner.nextLine();

        return participants.get(option);
    }

    public void update() {
        this.isEmpty();

        Participant participant = this.get();

        System.out.print("Enter name: ");
        String input = scanner.nextLine();
        participant.setName(input.isEmpty() ? participant.getName() : input);
    }

    public void delete() {
        this.isEmpty();

        Participant participant = this.get();
        participants.remove(participant);
    }

    public void list() {
        this.isEmpty();

        int pos = 0;
        for(Participant participant : participants) {
            System.out.println("\n\t#" + pos + ": "
                    + "\t" + participant);
            pos++;
        }
    }

    public void isEmpty() {
        if(participants.isEmpty()){
            System.out.println("\nNo participants available!");
            return;
        }
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public Participant getParticipant(int index) {
        return participants.get(index);
    }


}
