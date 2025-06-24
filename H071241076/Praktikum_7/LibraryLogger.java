import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LibraryLogger {
    List<String> logs = new ArrayList<>();

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String log = timestamp + " " + activity;
        logs.add(log);
        return log;
    }

    public String getLogs() {
        if (logs.isEmpty()) {
            return "Tidak ada log aktivitas.";
        }
        return String.join("\n", logs);
    }


    public void clearLogs() {
        logs.clear();
    }
}