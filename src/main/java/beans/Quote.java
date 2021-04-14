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

    public FileWriter saveTOFile(){
        FileWriter writer = null;
        try {
            writer = new FileWriter("Quote_1.txt");
            try {
                writer.write(returnResponse());
                writer.close();
            }catch (InterruptedException | IOException exc){
                exc.printStackTrace();
            }
        }catch (IOException exc){
            exc.printStackTrace();
        }
        return writer;
    }

    public String returnQuoteAndAutor(){
        String quote = "";
        String author = "";
        int lineCount = 0;
        File file = new File("Quote_1.txt");
        try{
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                String searchedLine = scan.nextLine();
                lineCount++;
                if(lineCount == 435){
                    quote = scan.nextLine();
                    String[] splitsSearchedQuote = quote.split("((<p)|(>)|(</a>)|(title=))+");
                    String[] splitSearchedAuthor = splitsSearchedQuote[4].split(" ");
                    quote = splitsSearchedQuote[4];
                    author = splitSearchedAuthor[2];
                }
            }
        }catch (FileNotFoundException exc){
            exc.printStackTrace();
        }
        return quote + " " + author;
    }
}
