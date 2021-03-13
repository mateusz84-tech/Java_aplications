package simple_processing_App;

import java.util.List;
import java.util.Scanner;

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
            if(student.getName().equals(name)){
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
}
