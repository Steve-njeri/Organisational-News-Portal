package models;

import java.util.Objects;

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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNumber_employees() {
        return number_employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department department = (Department) o;
        return id == department.id &&
                Objects.equals(name, department.name) &&
                Objects.equals(description, department.description) &&
                Objects.equals(number_employees, department.number_employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, description, number_employees);
    }

}
