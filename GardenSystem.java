import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import javax.swing.*;
//import java.awt.*;
import javax.swing.border.Border;

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
                        JOptionPane.showMessageDialog(null, "Plant successfully added!");
                    }
                });

                panel.add(imgLabel1);
                panel.add(imgLabel2);
                panel.add(imgLabel3);
                panel.add(imgLabel4);
                panel.add(txtAdd);
                panel.add(addBtn);
                
                plantFrame.add(panel, BorderLayout.NORTH);
                //plantFrame.add(panel, BorderLayout.SOUTH);
                plantFrame.setSize(500, 350);
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




