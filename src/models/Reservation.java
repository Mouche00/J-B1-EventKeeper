package models;

public class Reservation {

    private Event event;
    private Participant participant;


    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Reservation() {}

    public Reservation(Event event, Participant participant) {
        this.event = event;
        this.participant = participant;
    }

//    public Reservation clone() throws CloneNotSupportedException {
//        Reservation reservation = (Reservation) super.clone();
//        return reservation;
//    }
}
