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

    public static void displayGraph(List<Student> list){

        int[] arrayGrade = new int[11];
        // przypisanie do tablicy ilości ocen z danego zakresu
        for(Student student : list){
            if(student.getGrade() > 0 && student.getGrade() < 10){
                arrayGrade[0]++;
            }
            if(student.getGrade() > 9 && student.getGrade() <= 19){
                arrayGrade[1]++;
            }
            if(student.getGrade() > 19 && student.getGrade() <= 29){
                arrayGrade[2]++;
            }
            if(student.getGrade() > 29 && student.getGrade() <= 39){
                arrayGrade[3]++;
            }
            if(student.getGrade() > 39 && student.getGrade() <= 49){
                arrayGrade[4]++;
            }
            if(student.getGrade() > 49 && student.getGrade() <= 59){
                arrayGrade[5]++;
            }
            if(student.getGrade() > 59 && student.getGrade() <= 69){
                arrayGrade[6]++;
            }
            if(student.getGrade() > 69 && student.getGrade() <= 79){
                arrayGrade[7]++;
            }if(student.getGrade() > 79 && student.getGrade() <= 89){
                arrayGrade[8]++;
            }
            if(student.getGrade() > 89 && student.getGrade() <= 99){
                arrayGrade[9]++;
            }
            if(student.getGrade() == 100){
                arrayGrade[10]++;
            }
        }

        // wyświetlanie zakresu ocen
        System.out.println("Wykres z ocenami.");
        for(int i=0; i< 11; i++){
            if(i == 10){
                System.out.printf("%7d: ", 100);
            }
            else{
                System.out.printf("%02d-%02d: ",
                        i * 10, i * 10 + 9);
            }
            // wyświetlenie odpowiedniej ilości gwiazdek przy danym zakresie oceny
            for(int stars=0; stars<arrayGrade[i]; stars++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
