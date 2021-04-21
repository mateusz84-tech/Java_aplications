package DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        final String GET_ALL = "SELECT * FROM theaters";

        displayAll("db_mk",GET_ALL);
    }
}
