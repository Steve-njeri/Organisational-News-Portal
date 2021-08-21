package dao;

import models.Department;
import models.DepartmentNews;
import models.Users;

import java.util.List;

public interface DepartmentDao {
    void add(Department department);

    //Get all departments
    List<Department> getAllDepartments();

    List<Users> getDepartmentUsersById(int id);

    List<DepartmentNews> getDepartmentNewsById(int id);

    Department findDepartmentById(int id);

    void updateDepartment(Department department, String name, String description);

    void clearAllDepartments();

}
