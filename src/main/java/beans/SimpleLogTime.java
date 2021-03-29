package beans;

import java.time.LocalDateTime;

public class SimpleLogTime implements LogService{

    @Override
    public void log() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Data: " + dateTime.getDayOfMonth() +
                ":" + dateTime.getMonth()+":"+dateTime.getYear());
        System.out.println("Time: " + dateTime.getHour() +
                ":"+ dateTime.getMinute() + ":"+ dateTime.getSecond());

    }
}
