package simple_processing_App;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FunctionManagerTest {

    private FunctionManager functionManager;

    @Before
    public void create(){
        functionManager = new FunctionManager();
    }

    //todo dokończyć test metody dodającą studenta
    @Test
    public void addNewStudentTest(){
        FunctionManager.addNewStudent(null);
    }

}