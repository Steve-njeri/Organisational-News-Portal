package models;

import org.junit.Test;

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
    }

    @Test
    public void setId() throws Exception{
        News news = setupNews();
        news.setUser_id(7);
        assertNotEquals(3,news.getId());
    }

    //helper
    public News setupNews() {
        return new News(1,0012,"Sports","FA Cup, Qualification");
    }

}