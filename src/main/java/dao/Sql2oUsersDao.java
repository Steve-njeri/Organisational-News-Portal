package dao;

import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oUsersDao implements UsersDao {
    private final Sql2o sql2o;

    public Sql2oUsersDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Users> getAllUsers() {
        String sql="SELECT * from users";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Users.class);
        }

    }

    @Override
    public void addUser(Users user) {

    }

    @Override
    public Users findUserById(int id) {
        return null;
    }

    @Override
    public void updateUsers(Users users, String name, String position, String role, int departmentId) {

    }

    @Override
    public void clearAllUsers() {

    }

    public void addUsers(Users users) {
    }
}