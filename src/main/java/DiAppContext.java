import beans.MangerMemoryStudent;
import beans.Student;
import config.AppConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiAppContext {

    public static void main(String[] args) {

        //
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MangerMemoryStudent student =
                context.getBean( "memoryStudent",MangerMemoryStudent.class);
        student.addStudent(new Student(1,"Ala","Nowak",80));
        student.addStudent(new Student(2,"Jan","Kowalski",10));
        student.showListSize();
        student.removeStudent(0);
        student.displayAll();

    }
}
