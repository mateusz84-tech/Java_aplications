package simple_processing_App;

public class Student {

    private final String name;
    private int grade;

    public Student(String name){
        if(name == null){
            throw new IllegalArgumentException("Imię nie może być nulem.");
        }
        if(name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("Imię nie może być puste.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if(grade < 0){
            throw new IllegalArgumentException("Wynik nie może być mniejszy od zera.");
        }
        if(grade > 100){
            throw new IllegalArgumentException("Maksymalny wynik 100.");
        }
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s: %s, %s: %d%n",
                "Imię",getName(),"wynik",getGrade());
    }
}
