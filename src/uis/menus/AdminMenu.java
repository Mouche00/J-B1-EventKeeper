package uis.menus;

import dtos.EventDTO;
import dtos.ParticipantDTO;
import services.EventService;
import services.ParticipantService;
import uis.inputs.EventInputs;
import uis.inputs.ParticipantInputs;
import utils.Validator;

public class AdminMenu extends Menu {

    public AdminMenu(EventService eventService, ParticipantService participantService) {
        super(eventService, participantService);
    }

    @Override
    public int prompt() {
        System.out.println("\n##############################################################################");
        System.out.println("####                                                                      ####");
        System.out.println("####                 --  Welcome Back Administrator  --                   ####");
        System.out.println("####                                                                      ####");
        System.out.println("##############################################################################");
        System.out.println("\nSelect an option:"
                + "\n1 - List Events"
                + "\n2 - Create Event"
                + "\n3 - Update Event"
                + "\n4 - Delete Event"
                + "\n5 - Search Events (Title, Date, Location, Type)"
                + "\n6 - List Participants"
                + "\n7 - Create Participant"
                + "\n8 - Update Participant"
                + "\n9 - Delete Participant"
                + "\n0 - Go Back");
        System.out.print("> ");
        return Validator.validateInteger(scanner.nextLine());
    }

    @Override
    public void choice(int option) {
        EventInputs eventInputs = new EventInputs();
        ParticipantInputs participantInputs = new ParticipantInputs();

        switch(option){
            case 0:
                break;
            case 1:
                if(!Validator.listIsEmpty(eventService.getEvents())) eventService.listAll();
                break;
            case 2:
                EventDTO eventCreateDTO = eventInputs.create();
                eventService.create(eventCreateDTO);
                break;
            case 3:
                if(!Validator.listIsEmpty(eventService.getEvents())) {
                    eventService.listAll();
                    int index = eventInputs.getIndex(eventService.getEvents().size());
                    EventDTO eventUpdateDTO = eventInputs.update();
                    eventService.update(index, eventUpdateDTO);
                }
                break;
            case 4:
                if(!Validator.listIsEmpty(eventService.getEvents())) {
                    eventService.listAll();
                    int index = eventInputs.getIndex(eventService.getEvents().size());
                    eventService.delete(index);
                }
                break;
            case 5:
                if(!Validator.listIsEmpty(eventService.getEvents())) {
                    String input = eventInputs.search();
                    eventService.search(input);
                }
                break;
            case 6:
                if(!Validator.listIsEmpty(participantService.getParticipants())) participantService.list();
                break;
            case 7:
                ParticipantDTO participantCreateDTO = participantInputs.create();
                participantService.create(participantCreateDTO);
                break;
            case 8:
                if(!Validator.listIsEmpty(participantService.getParticipants())) {
                    participantService.list();
                    int index = participantInputs.getIndex(participantService.getParticipants().size());
                    ParticipantDTO participantUpdateDTO = participantInputs.update();
                    participantService.update(index, participantUpdateDTO);
                }
                break;
            case 9:
                if(!Validator.listIsEmpty(participantService.getParticipants())) {
                    participantService.list();
                    int index = participantInputs.getIndex(participantService.getParticipants().size());
                    participantService.delete(index);
                }
                break;
            case 10:
                System.out.println("*********************************");
                System.out.println("||          -- REPORT --       ||");
                System.out.println("||                             ||");
                System.out.println("||     Number of events: " + eventService.getEvents().size() + "     ||");
                System.out.println("||  Number of participants: " + participantService.getParticipants().size() + "  ||");
                System.out.println("||  Number of reservations: " + participantService.getParticipants().size() + "  ||");
                System.out.println("||                             ||");
                System.out.println("**********************************");
                break;
            default:
                System.out.println("\nInvalid option!\n");
                break;
        }
    }
}
