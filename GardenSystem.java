import java.awt.*;
import java.util.*;
import java.util.List;

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

        Sensor temperatureSensor1 = new Sensor("Temperature Sensor 1");
        Sensor moistureSensor1 = new Sensor("Moisture Sensor 1");
        garden.addSensor(temperatureSensor1);
        garden.addSensor(moistureSensor1);

        // Initialize the garden systems
        WateringSystem wateringSystem = new WateringSystem(garden);
        SunlightSystem sunlightSystem = new SunlightSystem(garden);

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
            System.out.println("4. Show logs");
            System.out.println("5. Exit");
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
                    showLogs(loggingSystem, scanner);
                    break;
                case 5:
                    System.out.println("Exiting garden system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showLogs(LoggingSystem loggingSystem, Scanner scanner) {
        System.out.println("== Logs ==");
        loggingSystem.displayLogs();
        System.out.print("Press Enter to return to the main menu.");
        scanner.nextLine();
    }
}
