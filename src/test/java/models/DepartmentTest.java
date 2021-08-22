package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Test
    public void DepartmentInstantiatesCorrectly() throws Exception{
        Department department =setupDepartment();
        assertTrue(department instanceof Department);
    }

    @Test
    public void Department_instantiatesWithCorrectValues() throws Exception{
        Department department = setupDepartment();
        assertEquals("sales", department.getName());
        assertEquals("Marketing",department.getDescription());
    }

    @Test
    public void setId() throws Exception{
        Department department = setupDepartment();
        department.setId(3);
        assertNotEquals(2,department.getId());
    }

    // helper
    public Department setupDepartment() {
        return new Department(10,"sales", "Marketing");
    }

}