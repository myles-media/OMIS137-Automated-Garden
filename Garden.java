import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Garden {
    List<Plant> plants;
    List<Insect> insects;
    List<Sprinkler> sprinklers;
    List<Sensor> sensors;
    WateringSystem wateringSystem;
    SunlightSystem sunlightSystem;
    PestControlSystem pestControlSystem;

    public Garden() {
        plants = new ArrayList<>();
        insects = new ArrayList<>();
        sprinklers = new ArrayList<>();
        sensors = new ArrayList<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void addInsect(Insect insect) {
        insects.add(insect);
    }

    public void addSprinkler(Sprinkler sprinkler) {
        sprinklers.add(sprinkler);
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
    }
    public void updateGarden() {
        // You can add any logic here to update the garden state.
    }

    public void displayGardenStatus() {
        System.out.println("Garden Status:");
        System.out.println("Plants:");
        for (Plant plant : plants) {
            System.out.println(plant.getName() + " - Age: " + plant.getAge());
        }
        System.out.println("Insects:");
        for (Insect insect : insects) {
            System.out.println(insect.getName() + " - Age: " + insect.getAge());
        }
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }

    public void removeInsect(Insect insect) {
        insects.remove(insect);
    }

    public void removeSprinkler(Sprinkler sprinkler) {
        sprinklers.remove(sprinkler);
    }

    public void removeSensor(Sensor sensor) {
        sensors.remove(sensor);
    }

    public void simulateDay() {
        for (Plant plant : plants) {
            plant.tick();
        }
        for (Insect insect : insects) {
            insect.tick();
        }
        updateGarden();
        sunlightSystem.simulateSunlight();
        wateringSystem.executeWatering();
    }
}
