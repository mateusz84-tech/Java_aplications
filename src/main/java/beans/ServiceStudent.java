package beans;

import org.springframework.stereotype.Component;

@Component
public interface ServiceStudent {

    void addStudent(Student student);
    void removeStudent(int id);
    void displayAll();
}
