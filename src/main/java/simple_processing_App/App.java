package simple_processing_App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner inputChose = new Scanner(System.in);
        List<Student> list = new ArrayList<>();

        DisplayMenu.display();

        System.out.printf("%s: ","Wybierz");
        while(!inputChose.hasNextInt()){
            inputChose.next();
            System.out.println("Niepoprawny wybór. Spróbuj jeszcze raz: ");
        }
        int chose = inputChose.nextInt();

        switch (chose){
            case 1:{
                FunctionManager.addNewStudent(list);
            }break;

            default:
                System.out.println("Brak takiej opcji.");
        }

    }
}
