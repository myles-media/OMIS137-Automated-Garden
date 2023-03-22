import java.awt.*;
import java.util.*;

public class GardenSystem {
    public static void main(String[] args) {
        // Initialize the garden
        Garden garden = new Garden();

        // Add plants, insects, sprinklers, and sensors to the garden
        Plant mint1 = new Mint("Mint 1");
        Plant cilantro1 = new Cilantro("Cilantro 1");
        Plant basil1 = new Basil("Basil 1");
        garden.addPlant(mint1);
        garden.addPlant(cilantro1);
        garden.addPlant(basil1);

        Insect beetle1 = new Beetle("Beetle 1");
        Insect locust1 = new Locust("Locust 1");
        Insect spiderMites1 = new SpiderMites("Spider Mites 1");
        garden.addInsect(beetle1);
        garden.addInsect(locust1);
        garden.addInsect(spiderMites1);

        Sprinkler sprinkler1 = new Sprinkler(new Point(0, 0), 10, 2);
        Sprinkler sprinkler2 = new Sprinkler(new Point(10, 10), 5, 1.5);
        garden.addSprinkler(sprinkler1);
        garden.addSprinkler(sprinkler2);

        Sensor temperatureSensor1 = new Sensor("Temperature Sensor 1", "temperature");
        Sensor moistureSensor1 = new Sensor("Moisture Sensor 1", "moisture");
        garden.addSensor(temperatureSensor1);
        garden.addSensor(moistureSensor1);

        // Initialize the garden systems
        WateringSystem wateringSystem = new WateringSystem(garden);
        SunlightSystem sunlightSystem = new SunlightSystem(garden);
        PestControlSystem pestControlSystem = new PestControlSystem(garden);

        // Initialize the logging system
        LoggingSystem loggingSystem = new LoggingSystem();

        // Main loop
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display the main menu
            System.out.println("== Garden System Main Menu ==");
            System.out.println("1. Display garden status");
            System.out.println("2. Show watering schedule");
            System.out.println("3. Show sunlight schedule");
            System.out.println("4. Manage pest control");
            System.out.println("5. Show logs");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            // Get user input
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            // Process user choice
            switch (choice) {
                case 1:
                    garden.displayGardenStatus();
                    break;
                case 2:
                    System.out.println(wateringSystem.getWateringSchedule());
                    break;
                case 3:
                    sunlightSystem.displaySunlightSchedule();
                    break;
                case 4:
                    managePestControl(pestControlSystem, scanner, loggingSystem);
                    break;
                case 5:
                    showLogs(loggingSystem, scanner);
                    break;
                case 6:
                    System.out.println("Exiting garden system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper function to manage pest control
    // Helper function to manage pest control
    private static void managePestControl(PestControlSystem pestControlSystem, Scanner scanner, LoggingSystem loggingSystem) {
        while (true) {
            // Display the pest control menu
            System.out.println("== Pest Control Menu ==");
            System.out.println("1. Detect pests");
            System.out.println("2. Apply pest control methods");
            System.out.println("3. Add pest control method");
            System.out.println("4. Remove pest control method");
            System.out.println("5. Back to main menu");
            System.out.print("Enter choice: ");
            // Get user input
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            // Process user choice
            switch (choice) {
                case 1:
                    List<Insect> pests = pestControlSystem.detectPests();
                    if (pests.isEmpty()) {
                        System.out.println("No pests detected.");
                    } else {
                        System.out.println("Detected pests:");
                        for (Insect pest : pests) {
                            System.out.println("- " + pest.getName());
                        }
                    }
                    break;
                case 2:
                    Map<String, String> methods = pestControlSystem.getPestControlMethods();
                    System.out.println("Pest control methods:");
                    for (Map.Entry<String, String> entry : methods.entrySet()) {
                        System.out.println("- " + entry.getKey() + ": " + entry.getValue());
                    }
                    System.out.print("Enter pest control method to apply: ");
                    String method = scanner.nextLine();
                    System.out.print("Enter pest to apply method to: ");
                    String pestName = scanner.nextLine();
                    Insect pest = garden.getInsectByName(pestName);
                    if (pest == null) {
                        System.out.println("Invalid pest name.");
                    } else if (!methods.containsKey(method)) {
                        System.out.println("Invalid pest control method.");
                    } else {
                        pestControlSystem.applyPestControl(method, pest);
                        loggingSystem.addLog("Applied pest control method " + method + " to " + pestName, "Pest Control");
                    }
                    break;
                case 3:
                    System.out.print("Enter pest control method name: ");
                    String methodName = scanner.nextLine();
                    System.out.print("Enter pest control method description: ");
                    String methodDescription = scanner.nextLine();
                    pestControlSystem.addPestControlMethod(methodName, methodDescription);
                    loggingSystem.addLog("Added pest control method " + methodName, "Pest Control");
                    break;
                case 4:
                    Map<String, String> currentMethods = pestControlSystem.getPestControlMethods();
                    System.out.println("Current pest control methods:");
                    for (String methodName : currentMethods.keySet()) {
                        System.out.println("- " + methodName);
                    }
                    System.out.print("Enter pest control method name to remove: ");
                    String methodToRemove = scanner.nextLine();
                    if (!currentMethods.containsKey(methodToRemove)) {
                        System.out.println("Invalid pest control method name.");
                    } else {
                        pestControlSystem.removePestControlMethod(methodToRemove);
                        loggingSystem.addLog("Removed pest control method " + methodToRemove, "Pest Control");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper function to show logs
    private static void showLogs(LoggingSystem loggingSystem, Scanner scanner) {
        while (true) {
            // Display the logs menu
            System.out.println("== Logs Menu ==");
            System.out.println("1. Display all logs");
            System.out.println("2. Display logs by category");
            System.out.println("3. Search logs");
            System.out.println("4. Back to main menu");
            System.out.print("Enter choice: ");

            // Get user input
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            // Process user choice
            switch (choice) {
                case 1:
                    loggingSystem.displayLogs();
                    break;
            }
        }
    }
}
