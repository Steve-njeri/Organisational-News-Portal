package dao;

import models.Department;
import models.DepartmentNews;
import models.Users;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {

    private Sql2o sql2o;
    private final Sql2oUsersDao usersDao;
    private final Sql2oNewsDao newsDao;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
        this.usersDao = new Sql2oUsersDao();
        this.newsDao = new Sql2oNewsDao();
    }

    @Override
    public void add(Department department) {

    }

    @Override
    public List<Department> getAllDepartments() {
        return null;
    }

    @Override
    public List<Users> getDepartmentUsersById(int id) {
        return null;
    }

    @Override
    public List<DepartmentNews> getDepartmentNewsById(int id) {
        return null;
    }

    @Override
    public Department findDepartmentById(int id) {
        return null;
    }

    @Override
    public void updateDepartment(Department department, String name, String description) {

    }

    @Override
    public void clearAllDepartments() {

    }
}
