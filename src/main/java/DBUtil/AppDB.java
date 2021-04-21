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

        final String EDIT_DATA = "UPDATE theaters SET name = ?, address = ?, city = ? WHERE id = ?";

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
                String name = "";
                String address = "";
                String city = "";
                int id = 0;
                Scanner scan = new Scanner(System.in);
                System.out.println("Edycja danych...");
                System.out.print("Wpisz nową nazwę teatru: ");
                try{
                    name = scan.nextLine();
                }catch (InputMismatchException exc){
                    System.out.println("Błędne dane.");
                }
                System.out.print("Wpisz nowy adres:");
                try{
                    address = scan.nextLine();
                }catch (InputMismatchException exc){
                    System.out.println("Błęde dane.");
                }
                System.out.println("Wpisz miasto: ");
                try{
                    city = scan.nextLine();
                }catch (InputMismatchException exc){
                    System.out.println("Błędne dane.");
                }
                System.out.print("Wpisz id zmienianego rekordu: ");
                try{
                    id = scan.nextInt();
                }catch (InputMismatchException exc){
                    System.out.println("Błędne dane.");
                }

                try(Connection connection = DBUtil.conn("db_mk")){
                    PreparedStatement edit = connection.prepareStatement(EDIT_DATA);
                    edit.setString(1,name);
                    edit.setString(2,address);
                    edit.setString(3,city);
                    edit.setInt(4,id);

                    edit.executeUpdate();
                    System.out.println("Uaktualniono dane.");
                    displayAll("db_mk",GET_ALL);

                }catch (SQLException exc){
                    exc.printStackTrace();
                }
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
