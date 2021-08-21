package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Test
    public void UsersInstantiatesCorrectly_true() throws Exception{
        Users users = setupUsers();
        assertTrue(users instanceof Users);
    }

    @Test
    public void UsersInstantiatesCorrectlyWith_Values()throws Exception{
        Users users= setupUsers();
        assertEquals("Stephen",users.getName());
        assertEquals("CEO",users.getPosition());
        assertEquals("managing the overall operations",users.getRole());
        assertEquals(1122,users.getDepartmentId());
    }

    @Test
    public void setId()throws Exception{
        Users users = setupUsers();
        users.setId(5);
        assertNotEquals(2,users.getId());

    }

    public Users setupUsers() {
        return new Users("Stephen", "CEO", "managing the overall operations",1122);
    }

}