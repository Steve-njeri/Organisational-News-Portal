package dao;

import models.Department;
import models.DepartmentNews;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.stream.Collectors;

public class Sql2oDepartmentDao implements DepartmentDao {

    private Sql2o sql2o;
    private final Sql2oUsersDao usersDao;
    private final Sql2oNewsDao newsDao;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
        this.usersDao = new Sql2oUsersDao(sql2o);
        this.newsDao = new Sql2oNewsDao(sql2o);
    }

//    Add all departments
    @Override
    public void add(Department department) {
        String sql = "INSERT into departments (name,description) VALUES (:name,:description) ";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

//    Get all departments
    @Override
    public List<Department> getAll() {
        String sql ="SELECT * from departments";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Department.class);
        }

    }

//    find departments by id
    @Override
    public Department findById(int id) {
        String sql ="SELECT * from departments where id=:id";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Department.class);
        }

    }

//    update departments
    @Override
    public void update(Department department, String name, String description) {
        String sql = "UPDATE departments set (name, description) = (:name, :description) ";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("description", description)
                    .executeUpdate();
            department.setName(name);
            department.setDescription(description);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

//    Get all users by ID
    @Override
    public List<Users> getDepartmentUsersById(int id) {
        return usersDao.getAllUsers().stream()
                .filter(users -> users.getDepartmentId()== id )
                .collect(Collectors.toList());
    }

    //    Get all DepartmentNews by ID
    @Override
    public List<DepartmentNews> getDepartmentNewsById(int id) {
        return newsDao.getDepartmentNews().stream()
                .filter(department -> department.getDepartmentId()== id)
                .collect(Collectors.toList());
    }


//    clear all departments
    @Override
    public void clearAll() {
        String sql = "DELETE from departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }


}
