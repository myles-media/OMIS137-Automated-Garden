import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LoggingSystem {
    List<String> logs;
    Map<String, List<String>> categories;

    public LoggingSystem() {
        logs = new ArrayList<>();
        categories = new HashMap<>();
    }

    public void addLog(String log, String category) {
        logs.add(log);
        if (categories.containsKey(category)) {
            categories.get(category).add(log);
        } else {
            List<String> newCategory = new ArrayList<>();
            newCategory.add(log);
            categories.put(category, newCategory);
        }
    }
    public void displayLogs() {
        System.out.println("Logs:");
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public void displayLogsByCategory(String category) {
        System.out.println("Logs for category " + category + ":");
        if (categories.containsKey(category)) {
            for (String log : categories.get(category)) {
                System.out.println(log);
            }
        } else {
            System.out.println("No logs found for category " + category);
        }
    }

    public void saveLogsToFile(String filename) {
        // Implement logic to save logs to a file
    }

    public void loadLogsFromFile(String filename) {
        // Implement logic to load logs from a file
    }
}
