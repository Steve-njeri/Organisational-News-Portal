//package dao;
//
//import models.DepartmentNews;
//import models.News;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//import java.sql.Timestamp;
//import java.util.Arrays;
//import java.util.Date;
//
//import static org.junit.Assert.*;
//
//public class Sql2oNewsDaoTest {
//
//    private static  Sql2oNewsDao newsDao;
//    private static Connection con;
//
//
//    @BeforeClass
//    public static void setUp() throws Exception {
//        String connectionStr="jdbc:postgresql://localhost:5432/organisationalportal_test";
//        Sql2o sql2o = new Sql2o(connectionStr,"stephen","12345");
//
//        newsDao = new Sql2oNewsDao(sql2o);
//        con = sql2o.open();
//        newsDao.clearAllNews();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        newsDao.clearAllNews();
//    }
//
//    @AfterClass
//    public static void shutDown() throws Exception {
//        con.close();
//    }
//
//    @Test
//    public void getAllNews_ReturnsAllNews_True() {
//        News news = setupNews();
//        News newsTwo = setupNews();
//
//        newsDao.addNews(news);
//        newsDao.addNews(newsTwo);
//
//        DepartmentNews departmentNews = setupDepartmentNews();
//        DepartmentNews departmentNewsTwo = setupDepartmentNews();
//
//        newsDao.addDepartmentNews(departmentNews);
//        newsDao.addDepartmentNews(departmentNewsTwo);
//
//        assertEquals(4,newsDao.getAllNews().size());
//        assertTrue(newsDao.getAllNews().containsAll(Arrays.asList(news,newsTwo,departmentNews,departmentNewsTwo)));
//
//    }
//
//    @Test
//    public void getGeneralNews_ReturnsGeneralNews_True() {
//        News news = setupNews();
//        News newsTwo = setupNews();
//
//        newsDao.addNews(news);
//        newsDao.addNews(newsTwo);
//
//        DepartmentNews departmentNews = setupDepartmentNews();
//        DepartmentNews departmentNewsTWo = setupDepartmentNews();
//
//        newsDao.addDepartmentNews(departmentNews);
//        newsDao.addDepartmentNews(departmentNewsTWo);
//
//        int news_id = news.getId();
//        int newsTwo_id = newsTwo.getId();
//
//        assertEquals(2,newsDao.getNews().size());
//        assertTrue(newsDao.getNews().containsAll(Arrays.asList(news,newsTwo)));
//    }
//
//    private DepartmentNews setupDepartmentNews() {
//        return new DepartmentNews(0012,"Sports" ,"FA Cup, Qualification", new Timestamp(new Date().getTime()), 00111);
//
//    }
//
//    private News setupNews() {
//        return new News(0012,"Sports","FA Cup, Qualification", new Timestamp(new Date().getTime()));
//    }
//
//
//}