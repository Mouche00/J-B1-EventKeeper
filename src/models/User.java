package models;

abstract public class User {

    protected int id;
    protected String name;

    private static int counter = 0;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public User(String name) {
        this.id = counter++;
        this.name = name;
    }

    @Override
    public String toString(){
        return "\n\tId: " + this.id
                + "\n\tName: " + this.name;
    }
}
