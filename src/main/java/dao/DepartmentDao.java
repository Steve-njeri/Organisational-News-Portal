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
    List<Users> getDepartmentUsersById(int id);


    //update
    void update(int id, String name, String description);

    //delete department
    void deleteById(int id);
    void clearAll();

}
