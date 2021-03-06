package models;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

public class DepartmentNewsTest {

    @Test
    public void NewsInstantiatesCorrectly() throws Exception{
        DepartmentNews departmentNews = setupDepartmentNews();
        assertTrue(departmentNews instanceof DepartmentNews);
    }

    @Test
    public void DepartmentNewsInstantiatesCorrectlyWith_Values() throws Exception{
        DepartmentNews departmentNews = setupDepartmentNews();
        assertEquals(0012,departmentNews.getUser_id());
        assertEquals("Sports",departmentNews.getTitle());
        assertEquals("FA Cup, Qualification",departmentNews.getContent());
        assertEquals(00111,departmentNews.getDepartmentId());

    }

    @Test
    public void setId() throws Exception{
        DepartmentNews departmentNews = setupDepartmentNews();
        departmentNews.setid(7);
        assertNotEquals(3,departmentNews.getId());
    }

    //helper
    public DepartmentNews setupDepartmentNews() {
        return new DepartmentNews(1,0012,"Sports" ,"FA Cup, Qualification", 00111);
    }



}