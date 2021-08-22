package dao;

import models.Department;
import models.DepartmentNews;
import models.Users;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

public class Sql2oDepartmentDaoTest {
    private static  Sql2oDepartmentDao departmentDao;
    private static Sql2oUsersDao usersDao;
    private static Sql2oNewsDao newsDao;
    private static Connection con;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString="jdbc:postgresql://localhost:5432/organisationals_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "stephen", "123456");

        departmentDao = new Sql2oDepartmentDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        con = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
        departmentDao.clearAll();
        usersDao.clearAllUsers();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        con.close();
    }

    @Test
    public void addedDepartmentsAreReturnedFromGetAll_True() {
        Department department = setupDepartment();
        departmentDao.add(department);
        Department otherDepartment = new Department(10, "sales", "Marketing");
        departmentDao.add(otherDepartment);
        assertEquals(2, departmentDao.getAll().size());
        assertTrue(departmentDao.getAll().containsAll(Arrays.asList(department,otherDepartment)));
    }

    @Test
    public void getDepartmentUsersById_ReturnsAll_True() {
        Department department = setupDepartment();
        departmentDao.add(department);
        Department otherDepartment = new Department(10, "sales", "Marketing");
        departmentDao.add(otherDepartment);

        Users users = setupUsers();
        usersDao.addUsers(users);
        usersDao.updateUsers(users,users.getName(),users.getPosition(),users.getRole(),department.getId());

        Users otherUsers = new Users("Stephen", "CEO", "managing the overall operations",1122);
        usersDao.addUsers(otherUsers);
        usersDao.updateUsers(otherUsers,otherUsers.getName(),otherUsers.getPosition(),otherUsers.getRole(),department.getId());
    }

    @Test
    public void getDepartmentNewsById_ReturnsAll_True() {
        Department department = setupDepartment();
        departmentDao.add(department);
        Department otherDepartment = new Department(10, "sales", "Marketing");
        departmentDao.add(otherDepartment);

        DepartmentNews departmentNews = setupDepartmentNews();
        newsDao.addDepartmentNews(departmentNews);
        newsDao.updateDepartmentNews(departmentNews,departmentNews.getUser_id(),departmentNews.getContent(),department.getId());

        DepartmentNews otherDepartmentNews =  new DepartmentNews(0012,"Sports" ,"FA Cup, Qualification", new Timestamp(new Date().getTime()), 00111);
        newsDao.addDepartmentNews(otherDepartmentNews);
        newsDao.updateDepartmentNews(otherDepartmentNews,otherDepartmentNews.getUser_id(),otherDepartmentNews.getContent(),department.getId());
    }

    @Test
    public void addsDepartmentSetsId_True() {
        Department department = setupDepartment();
        departmentDao.add(department);
        int departmentId = department.getId();

        Department otherDepartment = new Department(10, "sales", "Marketing");
        departmentDao.add(otherDepartment);
        int otherDepartmentId = otherDepartment.getId();

        assertEquals(departmentId,department.getId());
        assertEquals(otherDepartmentId,otherDepartment.getId());
    }

    @Test
    public void findById_CorrectDepartment_True() {
        Department department = setupDepartment();
        departmentDao.add(department);
        Department otherDepartment = new Department(10, "sales", "Marketing");
        departmentDao.add(otherDepartment);

        assertEquals(department,departmentDao.findById(department.getId()));
        assertEquals(otherDepartment,departmentDao.findById(otherDepartment.getId()));

    }

    @Test
    public void update_NameDescription_True() {
        Department department = setupDepartment();
        departmentDao.add(department);
        Department otherDepartment = new Department(10, "sales", "Marketing");
        departmentDao.add(otherDepartment);

        String name = department.getName();
        String description =department.getDescription();
        departmentDao.update(department,"Operations","Accounts opening ");
        assertNotEquals(name,department.getName());
        assertNotEquals(description,department.getDescription());
    }

    @Test
    public void clearAll() {
        Department department = setupDepartment();
        departmentDao.add(department);
        Department otherDepartment = new Department(10, "sales", "Marketing");
        departmentDao.add(otherDepartment);

        assertEquals(2,departmentDao.getAll().size());
        departmentDao.clearAll();
        assertEquals(0,departmentDao.getAll().size());
    }

    //helper
    private Department setupDepartment() {
        return new Department(10, "sales", "Marketing");
    }

    private Users setupUsers(){
        return new Users("Stephen", "CEO", "managing the overall operations",1122);
    }

    private DepartmentNews setupDepartmentNews() {
        return new DepartmentNews(0012,"Sports" ,"FA Cup, Qualification", new Timestamp(new Date().getTime()), 00111);
    }




}