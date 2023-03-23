import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.Timer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.Border;

public class GardenSystem {
    private static JFrame mainFrame;

    private static JMenuBar mb;
    private static JMenu fileMnu;
    private static JMenu plantMnu;
    private static JMenu optionMnu;

    private static JMenuItem fileExitMnuItm;
    private static JMenuItem plantAddMnuItm;
    private static JMenuItem PlantlistMnuItm;

    private static JMenuItem optionMnuItm1;
    private static JMenuItem optionMnuItm2;
    private static JMenuItem optionMnuItm3;
    private static JMenuItem optionMnuItm4;
    private static JPanel mainPanel;

    private static Garden garden; 
    private static WateringSystem wateringSystem;
    private static SunlightSystem sunlightSystem;
    private static LoggingSystem loggingSystem;
    
    private static LocalDateTime simulationStartTime = LocalDateTime.now();

    public static void main(String[] args) {
        // Initialize the garden
        garden = new Garden();

        // Add plants, insects, sprinklers, and sensors to the garden
        // Plant mint1 = new Mint("Mint");
        // garden.addPlant(mint1);

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
        wateringSystem = garden.getWateringSystem();
       sunlightSystem = garden.getSunlightSystem();

        // Initialize the logging system
        loggingSystem = new LoggingSystem();

        //Creating the Frame
        mainFrame = new JFrame("Garden System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 400);

        mb = new JMenuBar();
        fileMnu = new JMenu("FILE");
        plantMnu = new JMenu("PLANTS");
        optionMnu = new JMenu("OPTION");

        mb.add(fileMnu);
        mb.add(plantMnu);
        mb.add(optionMnu);
 
        JMenuItem fileExitMnuItm = new JMenuItem("Exit");
        JMenuItem plantAddMnuItm = new JMenuItem("Add New");
        JMenuItem PlantlistMnuItm = new JMenuItem("List of Plants");

        JMenuItem optionMnuItm1 = new JMenuItem("Garden status");
        JMenuItem optionMnuItm2 = new JMenuItem("Watering schedule");
        JMenuItem optionMnuItm3 = new JMenuItem("Sunlight schedule");
        JMenuItem optionMnuItm4 = new JMenuItem("Logs");
        
        // close window
        fileMnu.add(fileExitMnuItm);
        fileExitMnuItm.addActionListener(e -> mainFrame.dispose());
    
        plantMnu.add(plantAddMnuItm);
        plantMnu.add(PlantlistMnuItm);
        optionMnu.add(optionMnuItm1);
        optionMnu.add(optionMnuItm2);
        optionMnu.add(optionMnuItm3);
        optionMnu.add(optionMnuItm4);

        // garden status
        optionMnuItm1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showGardenStatus();
            }
        });

        // watering schedule
        optionMnuItm2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showWateringSchedule();
            }
        });

        optionMnuItm3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSunLightSchedule();
            }
        });

        optionMnuItm4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLogs();
            }
        });

        // add plant form
        plantAddMnuItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAddPlantForm();
            }
        });

        // List of plants
        PlantlistMnuItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showListOfPlants();
            }
        });

        ImageIcon Icon = new ImageIcon("src/images/garden.png");
        mainPanel = new JPanel();

        // Refresh every 5 seconds
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
        @Override
            public void run() {
                displayPlantOnGarden();
            }
        };
        timer.schedule(task, 0, 5000);

        JLabel background = new JLabel(Icon);
        mainFrame.add(background);
        mainFrame.getContentPane().add(BorderLayout.NORTH, mb);
        background.setLayout(new GridBagLayout());
        background.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private static void showLogs() {
        JFrame frame = new JFrame("Logs");
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (String logs: loggingSystem.logs) {
            listModel.addElement("Log - " + " " + logs);
        }
        JList<String> list = new JList<>(listModel);

        JPanel panel = new JPanel();
        panel.add(list);
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private static void showGardenStatus() {
        JFrame frame = new JFrame("Garden Status");
        DefaultListModel<String> listModel = new DefaultListModel<>();

        listModel.addElement("PLANTS");
        for (Plant plant : garden.plants) {
            listModel.addElement(plant.getName() + " - Age: " + plant.getAge());
        }
        
        listModel.addElement("------------------------------------------");
        listModel.addElement("INSECTS");
        for (Insect insect : garden.insects) {
            listModel.addElement(insect.getName() + " - Age: " + insect.getAge());
        }
        JList<String> list = new JList<>(listModel);

        JPanel panel = new JPanel();
        panel.add(list);
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private static void showWateringSchedule() {
        JFrame frame = new JFrame("Watering Schedule");
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (Plant plant : garden.plants) {
            listModel.addElement(plant.getName()+ " has: " + plant.getWaterLevel() + " units of water.");
            double requiredWater = (plant.getWaterRequirement() - plant.getWaterLevel());
            listModel.addElement("It needs: " + requiredWater + " more units");
            listModel.addElement("-------------------------------------------------");
        }
        JList<String> list = new JList<>(listModel);

        JPanel panel = new JPanel();
        panel.add(list);
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }

    private static void showSunLightSchedule() {
        JFrame frame = new JFrame("Sunlight schedule");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Today's sunlight hours: " + sunlightSystem.getSunlightHours() + " hours");
        JList<String> list = new JList<>(listModel);

        JPanel panel = new JPanel();
        panel.add(list);
        frame.add(panel);
        frame.setSize(400, 100);
        frame.setVisible(true);
    }

    private static void showAddPlantForm() {
        JFrame plantFrame = new JFrame("Add plant");
        JTextField txtAdd = new JTextField(null,10); // accepts upto 10 characters
        JButton addBtn = new JButton("Add to garden");
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); // create a 3x2 grid
        ImageIcon imgBasil = new ImageIcon("src/images/basil.png");
        ImageIcon imgcilan = new ImageIcon("src/images/cilantro.png");
        ImageIcon imgLemon = new ImageIcon("src/images/lemongrass.png");
        ImageIcon imgMint = new ImageIcon("src/images/mint.png");

        int width = 100; // set desired width
        Image image1 = imgBasil.getImage(); // get image from icon
        Image scaledImgBasil = image1.getScaledInstance(width, -1, Image.SCALE_SMOOTH); // scale the image
        ImageIcon scaledIconBasil = new ImageIcon(scaledImgBasil); // create new ImageIcon with scaled image

        Image image2 = imgcilan.getImage(); // get image from icon
        Image scaledImgcilan = image2.getScaledInstance(width, -1, Image.SCALE_SMOOTH); // scale the image
        ImageIcon scaledIconCilan = new ImageIcon(scaledImgcilan); // create new ImageIcon with scaled image

        Image image3 = imgLemon.getImage(); // get image from icon
        Image scaledImgLemon = image3.getScaledInstance(width, -1, Image.SCALE_SMOOTH); // scale the image
        ImageIcon scaledIconLemon = new ImageIcon(scaledImgLemon); // create new ImageIcon with scaled image

        Image image = imgMint.getImage(); // get image from icon
        Image scaledImgMint = image.getScaledInstance(width, -1, Image.SCALE_SMOOTH); // scale the image
        ImageIcon scaledIconMint = new ImageIcon(scaledImgMint); // create new ImageIcon with scaled image

        JLabel imgLabel1 = new JLabel(scaledIconBasil);
        imgLabel1.setName("Basil");
        JLabel imgLabel2 = new JLabel(scaledIconCilan);
        imgLabel2.setName("Cilantro");
        JLabel imgLabel3 = new JLabel(scaledIconLemon);
        imgLabel3.setName("Lemongrass");
        JLabel imgLabel4 = new JLabel(scaledIconMint);
        imgLabel4.setName("Mint");

        // Add a border to the JLabel
        Border border = BorderFactory.createLineBorder(null, 0);
        imgLabel1.setBorder(border);

        // Add a mouse listener to the JLabel to change the border on mouse hover
        imgLabel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                imgLabel1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imgLabel1.setBorder(border);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                txtAdd.setText("");
                txtAdd.setText(imgLabel1.getName());
            }
        });

        imgLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                imgLabel2.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imgLabel2.setBorder(border);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                txtAdd.setText("");
                txtAdd.setText(imgLabel2.getName());
            }
        });

        imgLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                imgLabel3.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imgLabel3.setBorder(border);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                txtAdd.setText("");
                txtAdd.setText(imgLabel3.getName());
            }
        });

        imgLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                imgLabel4.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                imgLabel4.setBorder(border);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                txtAdd.setText("");
                txtAdd.setText(imgLabel4.getName());
            }
        });

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textValue = txtAdd.getText();
                
                if (textValue.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a plant!");
                    return;
                }

                Plant thisPlant = new Plant(textValue);
                garden.addPlant(thisPlant);
                txtAdd.setText("");
                loggingSystem.addLog("Add new plant " + textValue, "plant");
                JOptionPane.showMessageDialog(null, "Plant successfully added!");
            }
        });

        panel.add(imgLabel1);
        panel.add(imgLabel2);
        panel.add(imgLabel3);
        panel.add(imgLabel4);
        panel.add(txtAdd);
        panel.add(addBtn);
        
        // add a WindowListener to handle the closing event
        plantFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mainFrame.getContentPane();
                mainFrame.setVisible(true);
            }
        });

        plantFrame.add(panel, BorderLayout.NORTH);
        plantFrame.setSize(500, 350);
        plantFrame.setVisible(true);
    }

    private static void showListOfPlants() {
        JFrame frame = new JFrame("Plant list");
        JTable table = new JTable(new DefaultTableModel(new Object[]{"Name", "Status", "Age"}, 0));
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String status = "Dead";
        for (Plant plant : garden.plants) {
            if (plant.isAlive) {
                status = "Alive";
            }
            model.addRow(new Object[]{plant.getName(), status, plant.getAge()});
        }
        
        JPanel panel = new JPanel();
        JButton removeBtn = new JButton("Remove");
        
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                String selectedValue = (String) table.getValueAt(row, 0);
                if (selectedValue == null) {
                    JOptionPane.showMessageDialog(null, "Select plant to remove!");
                    return;
                }
                
                for (Plant plant : garden.plants) {
                    if (selectedValue.equalsIgnoreCase(plant.getName())) {
                        garden.removePlant(plant);
                        loggingSystem.addLog("Remove plant " + plant.getName(), "plant");
                        JOptionPane.showMessageDialog(null, plant.getName() + " successfully removed !");
                        DefaultTableModel model = (DefaultTableModel) table.getModel(); // Assuming table is your JTable object
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) { // Make sure a row is actually selected
                            model.removeRow(selectedRow);
                        }
                    }
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(removeBtn);
        frame.add(scrollPane);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);

        // add a WindowListener to handle the closing event
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mainFrame.getContentPane();
                mainFrame.setVisible(true);
            }
        });
        
        frame.setSize(500, 200);
        frame.setVisible(true);
    }

    private static void displayPlantOnGarden() {
        mainPanel.removeAll();
        int i = 0;
        if (garden.plants.size() > 0) {
            for (Plant plant : garden.plants) {
                int width = 100; 
                ImageIcon imgCon = new ImageIcon("src/images/" + plant.getName() + ".png");
                Image img = imgCon.getImage(); 
                Image scaledImg = img.getScaledInstance(width, -1, Image.SCALE_SMOOTH);
                ImageIcon scaledImgIcon = new ImageIcon(scaledImg); 

                JLabel label = new JLabel(plant.getName());
                label.setIcon(scaledImgIcon);
                label.setBounds(50 + i * 20, 50 + (i * 50), 100, 30);
                label.setBorder(BorderFactory.createEmptyBorder(10, 10 + (1 * 20), 10, 10));
                mainPanel.add(label);
                i++;
            }
        }
        garden.simulateDay();
        garden.displayGardenStatus();
    }
}




