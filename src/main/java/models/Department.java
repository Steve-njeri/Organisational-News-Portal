package models;

import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private String description;

    public Department(int id,String name, String description){
        this.id = id;
        this.name= name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department department = (Department) o;
        return id == department.id &&
                Objects.equals(name, department.name) &&
                Objects.equals(description, department.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}
