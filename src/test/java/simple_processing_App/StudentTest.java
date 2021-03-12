package simple_processing_App;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void createStudent(){
        Student student = new Student("Name");
        assertEquals("Name", student.getName());
    }

}