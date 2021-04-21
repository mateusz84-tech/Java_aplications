package DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppDB {

    // funkcja wyświetlająca dane z tabeli z bazy danych
    public static void displayAll(String dbName, String query){
        try(Connection connect = DBUtil.conn("db_mk")){
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            ResultSet theaters = preparedStatement.executeQuery();
            System.out.printf("%s %20s %30s %30s%n","ID","NAZWA","ADRES","MIASTO");
            for(int i=1; i<90; i++){
                System.out.print("-");
            }
            System.out.println();
            while(theaters.next()){
                System.out.printf("%-5s %-35s %-35s %-30s%n",
                        theaters.getString("id"),
                        theaters.getString("name"),
                        theaters.getString("address"),
                        theaters.getString("city"));
            }
        }catch (SQLException exc){
            exc.printStackTrace();
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final String GET_ALL = "SELECT * FROM theaters";

        displayAll("db_mk",GET_ALL);

        System.out.println();
        System.out.printf("%45s%n","=========== MENU ===========");
        System.out.printf("%25s - %-5s%n","e","Edycja");
        System.out.printf("%25s - %-5s%n","u","Usuń");
        System.out.printf("%25s - %-5s%n","x","Wyjście");
        System.out.println();
        System.out.printf("%22s: ","Wybierz");

        String choose = "";
        try {
            choose = input.next();
        }catch (InputMismatchException exc){
            System.out.println("Błędne dane");
        }

        switch(choose){

            case "e": {
                System.out.println("Edycja danych...");
            }break;

            case "u": {
                System.out.println("Usuwanie danych...");
            }break;
            case "x": {
                System.out.println("Dziękuje za skorzystanie z programu.");
                System.exit(0);
            }break;

            default:
                System.out.println("Brak takiej opcji.");
        }
    }
}
