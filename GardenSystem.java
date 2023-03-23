import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import javax.swing.*;
//import java.awt.*;

public class GardenSystem {
    private static LocalDateTime simulationStartTime = LocalDateTime.now();

    public static void main(String[] args) {
        // Initialize the garden
        Garden garden = new Garden();

        // Add plants, insects, sprinklers, and sensors to the garden
        // Plant mint1 = new Mint("Mint");
        // Plant cilantro1 = new Cilantro("Cilantro");
        // Plant basil1 = new Basil("Basil");
        // Plant lemongrass1 = new Lemongrass("Lemongrass");
        // garden.addPlant(mint1);
        // garden.addPlant(cilantro1);
        // garden.addPlant(basil1);
        // garden.addPlant(lemongrass1);

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
        // Scanner scanner = new Scanner(System.in);
        // while (true) {
        //     // Display the main menu
        //     System.out.println("\n==============================");
        //     System.out.println("== Garden System Main Menu ==");
        //     System.out.println("==============================");
        //     System.out.println("1. Display garden status");
        //     System.out.println("2. Show watering schedule");
        //     System.out.println("3. Show sunlight schedule");
        //     System.out.println("4. Show logs");
        //     System.out.println("5. Date & Time");
        //     System.out.println("6. Exit");
        //     System.out.print("Enter choice: ");

        //     // Get user input
        //     int choice = scanner.nextInt();
        //     scanner.nextLine();  // Consume the newline character

        //     // Process user choice
        //     switch (choice) {
        //         case 1:
        //             garden.displayGardenStatus();
        //             break;
        //         case 2:
        //             System.out.println(wateringSystem.getWateringSchedule());
        //             break;
        //         case 3:
        //             sunlightSystem.displaySunlightSchedule();
        //             break;
        //         case 4:
        //             showLogs(loggingSystem, scanner);
        //             break;
        //         case 5:
        //             System.out.println("Simulation has been running for " + garden.simulationDays() + " days.");
        //             break;
        //         case 6:
        //             System.out.println("Exiting garden system. Goodbye!");
        //             return;
        //         default:
        //             System.out.println("Invalid choice. Please try again.");
        //     }
        // }

        //Creating the Frame
        JFrame frame = new JFrame("Garden System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu fileMnu = new JMenu("FILE");
        JMenu plantMnu = new JMenu("PLANTS");
        mb.add(fileMnu);
        mb.add(plantMnu);
 
        JMenuItem extMnuItm = new JMenuItem("Exit");
        JMenuItem addMnuItm = new JMenuItem("Add");
        JMenuItem listMnuItm = new JMenuItem("List");

         // close window
         fileMnu.add(extMnuItm);
         extMnuItm.addActionListener(e -> frame.dispose());
        
         plantMnu.add(addMnuItm);
         plantMnu.add(listMnuItm);

         // add plant form
        addMnuItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame plantFrame = new JFrame("Add plant");
                JPanel p1 = new JPanel();
                JLabel label = new JLabel("Enter Plant Name: ");
                JTextField txtAdd = new JTextField(null,10); // accepts upto 10 characters
                JButton addBtn = new JButton("Add");

                addBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String textValue = txtAdd.getText();
                        
                        if (textValue.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please input plant name!");
                            return;
                        }

                        Plant thisPlant = new Plant(textValue);
                        garden.addPlant(thisPlant);
                        txtAdd.setText("");
                        JOptionPane.showMessageDialog(null, "Plant successfully added!");
                    }
                });
                p1.add(label);
                p1.add(txtAdd);
                p1.add(addBtn);
                
                plantFrame.add(p1, BorderLayout.NORTH);
                plantFrame.setSize(400, 150);
                plantFrame.setVisible(true);
            }
        });

        // List of plants
        listMnuItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame plantFrame = new JFrame("Plant list");
                DefaultListModel<String> listModel = new DefaultListModel<>();
                
                for (Plant plant : garden.plants) {
                   // plant.getName() + " - Age: " + plant.getAge());
                   listModel.addElement(plant.getName());
                }
                JList<String> list = new JList<>(listModel);

                JPanel p1 =new JPanel();
                JLabel label = new JLabel("Plant List");
                JButton removeBtn = new JButton("Remove");

                removeBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedValue = (String) list.getSelectedValue();
                        if (selectedValue == null) {
                            JOptionPane.showMessageDialog(null, "Select plant to remove!");
                            return;
                        }
                        
                        // Plant basil1 = new Basil(selectedValue);
                        // Plant mint1 = new Mint(selectedValue);
                        Plant thisPlant = new Plant(selectedValue);
                        //Plant mint1 = new Mint(selectedValue);
                         //Plant cilantro1 = new Cilantro(selectedValue);
                        // Plant basil1 = new Basil(selectedValue);
                        //Plant lemongrass1 = new Lemongrass(selectedValue);
                        // garden.addPlant(mint1);
                        // garden.addPlant(cilantro1);
                        // garden.addPlant(basil1);
                        // garden.removePlant(lemongrass1);
                        // garden.removePlant(mint1);
                        // garden.removePlant(cilantro1);
                        // garden.removePlant(basil1);
                        //Plant thisPlant = new Plant(selectedValue);
                        garden.removePlant(thisPlant);

                        JOptionPane.showMessageDialog(null, thisPlant.getName());
                        
                        //JOptionPane.showMessageDialog(null, garden.plants.remove(loggingSystem));
                        garden.displayGardenStatus();
                    }
                });

                p1.add(label);
                p1.add(list);
                p1.add(removeBtn);
                
                plantFrame.add(p1, BorderLayout.NORTH);
                plantFrame.setSize(300, 150);
                plantFrame.setVisible(true);
            }
        });
 
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
    }

    private static void showLogs(LoggingSystem loggingSystem, Scanner scanner) {
        System.out.println("==Logs==");
        loggingSystem.displayLogs();
        System.out.print("Press Enter to return to the main menu.");
        scanner.nextLine();
    }
}




