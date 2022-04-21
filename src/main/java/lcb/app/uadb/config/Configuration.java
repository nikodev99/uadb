package lcb.app.uadb.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Configuration {

    public static LocalDateTime getDatetime(String datetime) {
        return getLocalDatetime(datetime, "yyyy-MM-dd HH:mm:ss");
    }

    public static LocalDateTime getLocalDatetime(String datetime, String format) {
        if (datetime == null) {
            return null;
        }
        return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(format));
    }
}
