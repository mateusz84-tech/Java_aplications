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

    @Test
    public void getNameTest(){
        Student student = new Student("Jan");
        assertEquals("Jan",student.getName());
    }
    @Test
    public void setGradeTest(){
        Student student = new Student("Ala");
        student.setGrade(95);
        assertEquals(95,student.getGrade());
    }
    @Test
    public void setGradeTestBoundaryValues(){
        Student student = new Student("Jan");
        student.setGrade(0);
        assertEquals(0,student.getGrade());
        student.setGrade(100);
        assertEquals(100, student.getGrade());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setGradeTestWithToLessValues(){
        Student student = new Student("Jan");
        student.setGrade(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setGradeTestWithThanMoreValue(){
        Student student = new Student("Jan");
        student.setGrade(101);
    }

}