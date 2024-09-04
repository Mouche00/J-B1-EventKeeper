package uis.inputs;

import dtos.EventDTO;
import dtos.ParticipantDTO;
import models.Participant;
import utils.Parser;
import utils.Validator;
import utils.enums.EventType;
import utils.enums.InputType;

import java.time.LocalDate;
import java.util.Scanner;

public class ParticipantInputs {
    int option;
    EventType type = null;
    Scanner scanner = new Scanner(System.in);

    public ParticipantDTO create() {

        String name = Validator.validateInput(
                "Enter name; ",
                InputType.STRING
        );

        return new ParticipantDTO(name);
    }

    public ParticipantDTO update() {
        ParticipantDTO participantDTO = new ParticipantDTO();

        System.out.print("Enter name: ");
        String input = scanner.nextLine();

        if(!input.isEmpty()) participantDTO.setName(input);
        return participantDTO;
    }

    public int getIndex(int listSize) {
        return Parser.parseInt(
                Validator.validateInput("> ", InputType.OPTION, 0, listSize));
    }
}
