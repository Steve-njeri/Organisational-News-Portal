package dao;

import models.DepartmentNews;
import models.News;
import models.Users;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {

    private static  Sql2oNewsDao newsDao;
    private static Connection con;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString="jdbc:postgresql://localhost:5432/organisationals_portal_test";
        Sql2o sql2o = new Sql2o(connectionString,"stephen","123456");

        newsDao = new Sql2oNewsDao(sql2o);
        con = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
        newsDao.clearAllNews();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        con.close();
    }

    @Test
    public void AddsNewsSetsId() {
        News news = setupNews();
        newsDao.add(news);
        int newsId = news.getId();

        News otherNews = new News(1,0012,"Sports","FA Cup, Qualification");
        newsDao.add(otherNews);
        int otherNewsId = otherNews.getId();

        assertEquals(newsId, news.getId());
        assertEquals(otherNewsId, otherNews.getId());
    }



    private DepartmentNews setupDepartmentNews() {
        return new DepartmentNews(1,0012,"Sports","FA Cup, Qualification", 00111);
    }

    private News setupNews() {
        return new News(1,0012,"Sports","FA Cup, Qualification");
    }


}

