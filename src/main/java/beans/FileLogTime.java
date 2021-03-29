package beans;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileLogTime implements LogService{
    @Override
    public void log() {
        try {
            LocalDateTime dateTime = LocalDateTime.now();
            PrintWriter writer = new PrintWriter("log.txt");
            writer.println(dateTime);

        }catch (FileNotFoundException exc){
            System.out.println("Błąd pliku");
        }
    }
}
