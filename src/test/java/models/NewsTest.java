package models;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class NewsTest {

    @Test
    public void NewsInstantiatesCorrectly() throws Exception{
        News news = setupNews();
        assertTrue(news instanceof News);
    }

    @Test
    public void NewsInstantiatesCorrectlyWith_Values() throws Exception{
        News news = setupNews();
        assertEquals(0012,news.getUser_id());
        assertEquals("Sports",news.getTitle());
        assertEquals("FA Cup, Qualification",news.getContent());
        assertEquals(new Timestamp(new Date().getTime()),news.getPostdate());
    }

    @Test
    public void setId() throws Exception{
        News news = setupNews();
        news.setId(7);
        assertNotEquals(3,news.getId());
    }

    //helper
    public News setupNews() {
        return new News(0012,"Sports","FA Cup, Qualification", new Timestamp(new Date().getTime()));
    }

}