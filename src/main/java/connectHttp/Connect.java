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
import java.util.StringTokenizer;

public class Connect {

    public static void main(String[] args){

        String pageBody = "";
        // nawiązanie połączenia z API
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(
                    HttpRequest.newBuilder()
                            .uri(URI.create("https://theysaidso.com/quote-of-the-day/inspire"))
                            .GET()
                            .build(),
                    HttpResponse.BodyHandlers.ofString());

            pageBody = response.body();
            System.out.println("Poprawnie połączono się ze stroną.");

        }catch (InterruptedException | IOException exc){
            System.out.println("Błąd połączenia ze stroną.");
        }

        // zapisanie do pliku zawartość strony
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

    // funkcja analizująca tekst w pliku, wyszukuje cytat dnia i jego autora
    public static void readQuoteWithFile(String fileName){
        String quote = "";      // do przechowywania cytatu;
        int lineCount = 0;      // do zliczania linii w tekście
        File readFile = new File(fileName);
        try {
            Scanner scan  = new Scanner(readFile);
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                lineCount ++;
                if(lineCount == 435){
                    quote = scan.nextLine();
                    String[] splitSearchedQuote = quote.split("((<p)|(>)|(</a>)|(title=\"Quote by ))+");
                    System.out.println();
                    String[] splitSearchedAuthor = splitSearchedQuote[3].split("(\" )*");
                    System.out.printf("%s%n", splitSearchedQuote[4]);
                    System.out.printf("%45s","Author: ");
                    int breakPoint = splitSearchedAuthor.length-1;
                    for(int i=0; i< splitSearchedAuthor.length;  i++){
                        if(splitSearchedAuthor[i].equals("\"")) break;
                        System.out.printf("%s ",splitSearchedAuthor[i]);
                    }
                }
            }

        }catch (FileNotFoundException exc){
            System.out.println("Błąd pliku");
            exc.printStackTrace();
        }
    }
    // funkcja pomocnicza do szukania cytatu z tekstu po rozdzieleniu tekstu ogranicznikami <>
    public String resultOfSearchQuoteWithString(String text){
        String quote = "";
        int count = 0;
        // podział tekstu na 6 części, trzecia część to cytat z wyszukanego wiersza w wcześniejszej metodzie
        StringTokenizer tokenizer = new StringTokenizer(text,"><");
        while (tokenizer.hasMoreElements()){
            count++;
            if(count == 2){
                quote = tokenizer.nextToken();
            }
        }
        return quote;
    }
}
