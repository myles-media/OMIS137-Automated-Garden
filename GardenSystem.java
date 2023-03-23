import java.awt.*;
import java.time.LocalDateTime;
import java.util.*;

public class GardenSystem {
    private static LocalDateTime simulationStartTime = LocalDateTime.now();

    public static void main(String[] args) {
        // Initialize the garden
        Garden garden = new Garden();

        // Add plants, insects, sprinklers, and sensors to the garden
        Plant mint1 = new Mint("Mint");
        Plant cilantro1 = new Cilantro("Cilantro");
        Plant basil1 = new Basil("Basil");
        Plant lemongrass1 = new Lemongrass("Lemongrass");
        garden.addPlant(mint1);
        garden.addPlant(cilantro1);
        garden.addPlant(basil1);
        garden.addPlant(lemongrass1);

        Insect beetle1 = new Beetle("Beetle");
        Insect locust1 = new Locust("Locust");
        Insect spiderMites1 = new SpiderMite("Spider Mite");
        Insect worm1 = new Worm("Worm");
        garden.addInsect(beetle1);
        garden.addInsect(locust1);
        garden.addInsect(spiderMites1);
        garden.addInsect(worm1);

        Sprinkler sprinkler1 = new Sprinkler(new Point(0, 0), 10, 2);
        Sprinkler sprinkler2 = new Sprinkler(new Point(10, 10), 5, 1.5);
        garden.addSprinkler(sprinkler1);
        garden.addSprinkler(sprinkler2);

        // Initialize the garden systems
        WateringSystem wateringSystem = garden.getWateringSystem();
        SunlightSystem sunlightSystem = garden.getSunlightSystem();


        // Initialize the logging system
        LoggingSystem loggingSystem = new LoggingSystem();

        // Main loop
        Scanner scanner = new Scanner(System.in);
        while (true) {
            garden.simulateDay();

            //String daySummary = garden.getDaySummary(); // Get the summary of the day's events
            //loggingSystem.addLog(daySummary, "simulation"); // Add a log entry for the day's events

            // Display the main menu
            System.out.println("\n==============================");
            System.out.println("== Garden System Main Menu ==");
            System.out.println("==============================");
            System.out.println("1. Display garden status");
            System.out.println("2. Show watering schedule");
            System.out.println("3. Show sunlight schedule");
            System.out.println("4. Show logs");
            System.out.println("5. Date & Time");
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
                    wateringSystem.displayWateringSystem();
                    break;
                case 3:
                    sunlightSystem.displaySunlightSchedule();
                    break;
                case 4:
                    showLogs(loggingSystem, scanner);
                    break;
                case 5:
                    System.out.println("Simulation has been running for " + garden.simulationDays() + " days.");
                    break;
                case 6:
                    System.out.println("Exiting garden system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showLogs(LoggingSystem loggingSystem, Scanner scanner) {
        System.out.println("==Logs==");
        loggingSystem.displayLogs();
        System.out.print("Press Enter to return to the main menu.");
        scanner.nextLine();
    }
}




