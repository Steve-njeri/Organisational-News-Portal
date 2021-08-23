package dao;

import models.Users;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Sql2oUsersDaoTest {
    private static  Sql2oUsersDao usersDao;
    private static Connection con;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString="jdbc:postgresql://localhost:5432/organisationals_portal_test";
        Sql2o sql2o = new Sql2o(connectionString, "stephen", "123456");

        Sql2oUsersDao usersDao = new Sql2oUsersDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        usersDao.clearAllUsers();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        con.close();
    }


    private Users setUpUsers() {
        return new Users("Stephen", "CEO", "managing the overall operations",1122);
    }





    }