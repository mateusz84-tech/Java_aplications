package simple_processing_App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner inputChose = new Scanner(System.in);
        List<Student> list = new ArrayList<>();

        for(;;) {
            DisplayMenu.display();

            System.out.printf("%s: ", "Wybierz");
            while (!inputChose.hasNextInt()) {
                inputChose.next();
                System.out.println("Niepoprawny wybór. Spróbuj jeszcze raz: ");
            }
            int chose = inputChose.nextInt();

            switch (chose) {
                case 1: {
                    FunctionManager.addNewStudent(list);
                }
                break;

                case 2: {
                    FunctionManager.assignExamGrade(list);
                }break;

                case 3: {
                    FunctionManager.findStudentByName(list);
                }break;
                case 4: {
                    FunctionManager.displayAllStudents(list);
                }break;
                case 5: {
                    FunctionManager.displayAverageGrade(list);
                }break;
                case 6: {
                    FunctionManager.showStudentWithMaxGrade(list);
                }break;
                case 7: {
                    FunctionManager.showStudentWithMinGrade(list);
                }break;
                case 8: {
                    FunctionManager.deleteStudent(list);
                }break;

                case 10: {
                    System.out.println("Dziękuje za skorzystanie z programu.");
                    System.exit(0);
                }
                default:
                    System.out.println("Brak takiej opcji.");
            }
        }
    }
}
