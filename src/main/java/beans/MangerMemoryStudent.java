package beans;

import java.util.ArrayList;
import java.util.List;

public class MangerMemoryStudent implements ServiceStudent{

    private List<Student> studentList = new ArrayList<>();
    @Override
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Dodano nowego studenta");
        System.out.println(student.getFirstName() + " " + student.getLastName());
    }

    @Override
    public void removeStudent(int id) {
        if(id < 0 || id > studentList.size()){
            throw new IllegalArgumentException("Błędne dane");
        }
        else{
            studentList.remove(id);
            System.out.println("Usunięto studenta o id: " + studentList.get(id).getId());
        }
    }

    @Override
    public void displayAll() {
        System.out.println("LISTA STUDENTÓW");
        for(Student students : studentList){
            System.out.println(students.toString());
        }
    }
}
