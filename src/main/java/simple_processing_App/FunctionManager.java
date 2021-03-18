package simple_processing_App;

import java.util.*;

public class FunctionManager {

    // funkcja dodaje nowego studenta do listy
    public static void addNewStudent(List<Student> list){
        Scanner input = new Scanner(System.in);
        System.out.printf("%s: ","Wprowadź imię");
        while(!input.hasNext("\\D{3,15}+")){
            input.next();
            System.out.print("Nieprawidłowe dane. Podaj jeszcze raz: ");
        }
        String name = input.next();
        Student student = new Student(name);
        list.add(student);
        System.out.println("Poprawnie dodano studenta: " + student.getName());
    }

    // funkcja wyszukuje studenta po imieniu, następnie można przypisać uczniowi wynik z egzaminu
    public static void assignExamGrade(List<Student> list){

//        final int MAX_VALUE = 100;
//        final int MIN_VALUE = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Wpisz imię studenta ");
        while(!input.hasNext("\\D{3,15}+")){
            input.next();
            System.out.print("Niepoprawne dane. Wpisz imię: ");
        }
        String name = input.next();
        for(Student student : list){
            if(student.getName().equalsIgnoreCase(name)){
                System.out.print("Przypisz ocenę: ");
                while(!input.hasNextInt()) {
                    input.nextInt();
                }
                int grade = input.nextInt();
                student.setGrade(grade);
            }
        }
        System.out.println("Przypisano ocenę z egzaminu");
    }

    // funkcja wyszukuje i wyświetla studenta
    public static void findStudentByName(List<Student> list){
        Scanner input = new Scanner(System.in);
        System.out.print("Wyszukaj po imieniu: ");
        while(!input.hasNext("\\D{3,15}+")){
            input.next();
            System.out.print("Niepoprawne imię. Wpisz poprawne imię: ");
        }
        String name = input.next();
        list.stream()
                .filter(st -> st.getName().equalsIgnoreCase(name))
                .forEach(System.out::println);
    }

    public static void displayAllStudents(List<Student> list){

        System.out.println("Lista studentów");
        list.forEach(System.out::println);
    }

    // wyświetla średnią z egzaminu
    public static void displayAverageGrade(List<Student> list){
        short sum = 0;

        for(Student student : list){
            sum += student.getGrade();
        }
        System.out.printf("%s %.2f%n","Średnia wynosi",
                (double)(sum / list.size()));
    }

    public static void showStudentWithMaxGrade(List<Student> list){

        Optional<Student> grade = list.stream()
                .max((student, t1) -> {
                    if (student.getGrade() < t1.getGrade()) {
                        student.setGrade(t1.getGrade());
                    }
                    return 0;
                });
        System.out.println("Wynik: " + grade.get().getGrade());

    }

    public static void showStudentWithMinGrade(List<Student> list){

        Optional<Student> grade = list.stream()
                .min((student, t1) -> {
                    if(student.getGrade() > t1.getGrade()){
                        student.setGrade(t1.getGrade());
                    }
                    return 0;
                });
        System.out.println("Wynik: " + grade.get().getGrade());
    }

    public static void deleteStudent(List<Student> list){
        Scanner input = new Scanner(System.in);
        System.out.printf("%s: ","Wyszukaj studenta po imieniu");
        while(!input.hasNext("\\D{3,15}+")){
            input.next();
            System.out.print("Niewłaściwe dane. Wpisz poprawnie imię.");
        }
        String name = input.next();
        if(list.size() == 0) {
            System.out.println("Lista studentów jest pusta nie ma kogo usunąć.");
        }
        else{
            list.removeIf(student -> student.getName().equalsIgnoreCase(name));
            System.out.println("Usunięto studenta z listy.");
        }

    }
}
