
import beans.MangerMemoryStudent;
import beans.Student;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiAppContext {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MangerMemoryStudent memoryStudent = context.getBean("memoryStudent", MangerMemoryStudent.class);
        memoryStudent.addStudent(new Student(1, "Jan", "Nowak", 34));
        memoryStudent.showListSize();
    }

}
