package services;

import dtos.ParticipantDTO;
import models.Participant;
import utils.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParticipantService {

    List<Participant> participants = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int option;

    public void create(ParticipantDTO participantDTO) {

        Participant participant = new Participant(participantDTO.getName());
        participants.add(participant);
    }

    public Participant get(int index){

        return participants.get(index);
    }

    public void update(int index, ParticipantDTO participantDTO) {

        Participant participant = this.get(index);

        if(participantDTO.getName() != null) {
            participant.setName(participantDTO.getName());
        }
    }

    public void delete(int index) {

        Participant participant = this.get(index);
        participants.remove(participant);
    }

    public void list() {
        Validator.listIsEmpty(participants);

        System.out.println("\n####");
        System.out.println("######## Participnts List: ");
        System.out.println("####");

        int pos = 0;
        for(Participant participant : participants) {
            System.out.println("\n#" + pos + ": "
                    + "\t" + participant);
            pos++;
        }
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public Participant getParticipant(int index) {
        return participants.get(index);
    }


}
