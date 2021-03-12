package simple_processing_App;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void createStudent(){
        Student student = new Student("Name");
        assertEquals("Name", student.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void createStudentWithNullValue(){
        Student student = new Student(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createStudentWithEmptyName(){
        Student student = new Student("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void createStudentWithWhiteSpacesName(){
        Student student = new Student("   ");
    }

}