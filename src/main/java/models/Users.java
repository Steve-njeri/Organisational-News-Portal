package models;

import java.util.Objects;

public class Users {
    private int id;
    private String name;
    private String position;
    private String role;
    private int departmentId;

    public Users(String name, String position, String role, int departmentId) {
        this.name = name;
        this.position = position;
        this.role = role;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getRole() {
        return role;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(name, users.name) &&
                Objects.equals(position, users.position) &&
                Objects.equals(role, users.role) &&
                Objects.equals(departmentId, users.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, role, departmentId);
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }
}
