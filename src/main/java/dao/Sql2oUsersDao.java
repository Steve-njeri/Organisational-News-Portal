package dao;

import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUsersDao implements UsersDao {
    private final Sql2o sql2o;

    public Sql2oUsersDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

//    Get all users
    @Override
    public List<Users> getAllUsers() {
        String sql = "SELECT * from users";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Users.class);
        }
    }

//    add users
    @Override
    public void addUsers(Users users) {
        String sql ="INSERT INTO users (name, position, role, departmentId) values (:name, :position, :role, :departmentId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        }catch (Sql2oException ex){
            System.out.println("An error occurs");
        }
    }


//    find users by id
    @Override
    public Users findUserById(int id) {
        String sql ="SELECT * FROM users where id = :id ";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql).addParameter("id",id)
                    .executeAndFetchFirst(Users.class);
        }
    }

//    update users
    @Override
    public void updateUsers(Users users, String name, String position, String role, int departmentId) {
        String sql = "UPDATE users set  (name,position,role,departmentId) = (:name,:position,:role,:departmentId) where id= :id ";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name",name)
                    .addParameter("position",position)
                    .addParameter("role",role)
                    .addParameter("departmentId",departmentId)
                    .addParameter("id",users.getId())
                    .executeUpdate();

            users.setName(name);
            users.setPosition(position);
            users.setRole(role);
            users.setDepartmentId(departmentId);
        }
    }

//    delete from users by id
    @Override
    public void deleteById(int id) {
        String sql = "DELETE from users WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println("Error Occurs");
        }
    }

//    clear all users
    @Override
    public void clearAllUsers() {
        String sql = "DELETE from users";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println("Error Occurs");
        }
    }
}