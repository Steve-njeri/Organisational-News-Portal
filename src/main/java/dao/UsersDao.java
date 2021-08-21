package dao;

import models.Users;

import java.util.List;

public interface UsersDao {

    List<Users> getAllUsers();

    void addUser(Users user);

    Users findUserById(int id);

    void updateUsers(Users users, String name, String position, String role, int departmentId);

    void clearAllUsers();
}
