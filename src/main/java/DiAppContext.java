import beans.MangerMemoryStudent;
import beans.Student;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiAppContext {

    public static void main(String[] args) {

        //
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MangerMemoryStudent student =
                context.getBean("memoryStudent",MangerMemoryStudent.class);
        student.addStudent(new Student(1,"Ala","Nowak",80));
        student.addStudent(new Student(2,"Jan","Kowalski",85));
        student.addStudent(new Student(3,"Aga","Bąk",95));

        student.displayAll();
        student.removeStudent(1);
        student.displayAll();

    }
}
