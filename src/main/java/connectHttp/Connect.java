package connectHttp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Connect {

    public static void main(String[] args){

        String pageBody = "";
        // nawiązanie połączenia z API
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(
                    HttpRequest.newBuilder()
                            .uri(URI.create("https://theysaidso.com/quote/larry-page-if-youre-changing-the-world-youre-working-on-important-things-youre-e"))
                            .GET()
                            .build(),
                    HttpResponse.BodyHandlers.ofString());

            pageBody = response.body();
            System.out.println("Poprawnie połączono się ze stroną.");

        }catch (InterruptedException | IOException exc){
            System.out.println("Błąd połączenia ze stroną.");
        }

        // zapis do pliku zawartość strony
        try {
            FileWriter writer = new FileWriter("quote.txt");
            writer.write(pageBody);
            writer.close();
        }catch (IOException exc){
            System.out.println("Błąd odczytu / zapisu pliku");
            exc.printStackTrace();
        }

        // wyświetlenie na konsoli cytatu dnia
        System.out.printf("%60s","Cytat dnia"+"\n");
        readQuoteWithFile("quote.txt");
    }

    // funkcja odczytująca z pliku cytatu
    public static void readQuoteWithFile(String fileName){
        String quote = "";
        File readFile = new File(fileName);
        try {
            Scanner scan = new Scanner(readFile);
            while(scan.hasNextLine()){
                if(scan.nextLine().contains("<div class=\"card-body\">")) {
                    quote = scan.nextLine();
                    String quoteOfTheDay = quote.substring(22,quote.length()-4);
                    System.out.printf("%10s",quoteOfTheDay);
                    break;
                }
            }
        }catch (FileNotFoundException exc){
            System.out.println("Błąd pliku");
            exc.printStackTrace();
        }
    }
}
