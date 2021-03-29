package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MangerMemoryStudent implements ServiceStudent{

    private LogService logService;
    private List<Student> studentList = new ArrayList<>();

    @Autowired
    public MangerMemoryStudent(LogService logService) {
        this.logService = logService;
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Dodano nowego studenta");
        logService.log();
        System.out.println(student.getFirstName() + " " + student.getLastName());
    }

    @Override
    public void removeStudent(int id) {
        if(id < 0 || id > studentList.size()){
            throw new IllegalArgumentException("Błędne dane");
        }
        else{
            studentList.remove(id);
            logService.log();
            System.out.println("Usunięto studenta o id: " + studentList.get(id).getId());
        }
    }

    @Override
    public void displayAll() {
        System.out.println("LISTA STUDENTÓW");
        for(Student students : studentList){
            System.out.println(students.toString());
            logService.log();
        }
    }
}
