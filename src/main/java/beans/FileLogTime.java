package beans;

import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;

@Component
public class FileLogTime implements LogService{

    private final String fileName;

    public FileLogTime(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log() {
        try {
            LocalDateTime dateTime = LocalDateTime.now();
            PrintWriter writer = new PrintWriter(fileName);
            writer.print(dateTime.getDayOfMonth() + ":" + dateTime.getMonthValue() + ":" + dateTime.getYear() + " ");
            writer.println(dateTime.getHour() + ":" + dateTime.getMinute() + ":" + dateTime.getSecond());
            writer.close();

        }catch (FileNotFoundException exc){
            System.out.println("Błąd pliku");
        }
    }
}
