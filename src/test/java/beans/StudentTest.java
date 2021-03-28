package beans;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private Student student;

    @Before
    public void create(){
        student = new Student(1,"Ala","Nowak",85);
    }

    @Test
    public void createNewStudent(){
        assertEquals(1,student.getId());
        assertEquals("Ala",student.getFirstName());
        assertEquals("Nowak",student.getLastName());
        assertEquals(85,student.getNote());
    }
    @Test(expected = IllegalArgumentException.class)
    public void createStudentWithLessThanZeroId(){
        student = new Student(-1,"Ala","Nowak", 10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createStudentWithEmptyFirstName(){
        student = new Student(1,"","Nowak",10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createdStudentWithTrimFirstName(){
        student = new Student(1,"   ","Nowak",10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createdStudentWithNoteLessThanZero(){
        student = new Student(1,"Ala","Nowak",-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createStudentWithNoteMoreThanHundred(){
        student = new Student(1,"Ala","Nowak",101);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createStudentWithEmptySurname(){
        student = new Student(1,"Ala","",10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createStudentWithSurnameTrim(){
        student = new Student(1,"Ala","   ",10);
    }


}