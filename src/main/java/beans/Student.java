package beans;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final int note;

    public Student(int id, String firstName, String lastName, int note) {
        if(id < 0 ){
            throw new IllegalArgumentException("Id nie może być ujemne.");
        }
        if(firstName.isEmpty() || firstName.isBlank()){
            throw new IllegalArgumentException("Błędne dane");
        }
        if(lastName.isEmpty() || lastName.isBlank()){
            throw new IllegalArgumentException("Błędne dane");
        }
        if(note < 0 || note > 100){
            throw new IllegalArgumentException("Błędne dane");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNote() {
        return note;
    }

    @Override
    public String toString() {
        return String.format("%s%n %s: %d%n %s %s%n %s: %d",
                "Student","Id",getId(),getFirstName(),getLastName(),
                "Ocena",getNote());
    }
}
