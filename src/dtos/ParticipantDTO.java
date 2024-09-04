package dtos;

public class ParticipantDTO {

    private String name;


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ParticipantDTO(String name) {
        this.name = name;
    }

    public ParticipantDTO(){}
}
