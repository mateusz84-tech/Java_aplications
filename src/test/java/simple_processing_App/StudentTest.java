package simple_processing_App;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private Student student;

    @Before
    public void create(){
        student = new Student("Jan");
    }

    @Test
    public void createStudent(){
        assertEquals("Jan",student.getName());
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

    @Test
    public void setGradeTest(){
        student.setGrade(95);
        assertEquals(95,student.getGrade());
    }
    @Test
    public void setGradeTestBoundaryValues(){
        student.setGrade(0);
        assertEquals(0,student.getGrade());
        student.setGrade(100);
        assertEquals(100, student.getGrade());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setGradeTestWithToLessValues(){
        student.setGrade(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setGradeTestWithThanMoreValue(){
        student.setGrade(101);
    }

}