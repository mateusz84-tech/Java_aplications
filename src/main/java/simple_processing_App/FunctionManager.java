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
        Student maxGrade = list.get(1);
        for(Student student : list){
            if(maxGrade.getGrade() < student.getGrade()){
                maxGrade.setGrade(student.getGrade());
            }
        }
        Student student1 = new Student(maxGrade.getName());
        System.out.printf("%s %s %s %d%n","Imię ",student1.getName(),
                "Wynik",maxGrade.getGrade());
    }
}
