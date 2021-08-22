package dao;

import models.Department;
import models.DepartmentNews;
import models.Users;

import java.util.List;

public interface DepartmentDao {

    //create
    void add(Department department);

    //Read
    List<Department> getAll();
    Department findById(int id);
    List<DepartmentNews> getDepartmentNewsById(int id);
    List<Users> getDepartmentUsersById(int id);


    //update
    void update(Department department, String name, String description);

    //delete
    void clearAll();

}
