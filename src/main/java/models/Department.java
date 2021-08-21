package models;

public class Department {
    private int id;
    private String name;
    private String description;
    private int number_employees;

    public Department(String name, String description, int number_employees){

        this.name= name;
        this.description = description;
        this.number_employees= number_employees;
    }
}
