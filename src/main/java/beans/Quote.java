package beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Quote {

    private String author;
    private String quote;

    public String returnResponse() throws InterruptedException, IOException{
        String pageBody = "";
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(
                HttpRequest.newBuilder()
                .uri(URI.create("https://theysaidso.com/quote-of-the-day/inspire"))
                .GET()
                .build(),HttpResponse.BodyHandlers.ofString());
        return pageBody = response.body();
    }

    // funkcja zapisująca zawartość strony do pliku
    public void saveTOFile(){
        FileWriter writer = null;
        try {
            writer = new FileWriter("Quote_1.txt");
            try {
                writer.write(returnResponse());  // przekazanie do writera wyniku działania poprzedniej funkcji - zawartości strony
                writer.close();
            }catch (InterruptedException | IOException exc){
                exc.printStackTrace();
            }
        }catch (IOException exc){
            exc.printStackTrace();
        }
    }
    // funkcja odczytująca z pliku tytuł i autora powiedzenia
    public void searchQuoteAndAutor(){
        String quote = "";
        String author = "";
        int lineCount = 0;
        File file = new File("Quote_1.txt");
        try{
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                scan.nextLine();
                lineCount++;
                if(lineCount == 435){ // odszukanie linii poprzedzającej linie z przysłowiem
                    quote = scan.nextLine();
                    String[] searchedQuote = quote.split("((<p)|(>)|(</a>)|(title=\"Quote by ))+");
                    quote = searchedQuote[4]; // przypisanie do wartości quote wydzielonego tekstu przy pomocy metody split i wyrażenia regularnego
                    String[] searchedAuthor = searchedQuote[3].split("(\" )+");
                    for (String s : searchedAuthor) {
                        author = s + " ";
                    }
                }
            }
        }catch (FileNotFoundException exc){
            exc.printStackTrace();
        }
        setAuthor(author);
        setQuote(quote);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}
