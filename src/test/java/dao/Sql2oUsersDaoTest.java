package dao;

import org.junit.BeforeClass;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oUsersDaoTest {
    private static  Sql2oUsersDao userDao;
    private static Connection con;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "stephen", "12345");

        userDao = new Sql2oUsersDao(sql2o);
        con = sql2o.open();
        userDao.clearAllUsers();
    }


}