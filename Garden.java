import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class Garden {
    List<Plant> plants;
    List<Insect> insects;
    List<Sprinkler> sprinklers;
    WateringSystem wateringSystem;
    SunlightSystem sunlightSystem;
    long startTime;

    public Garden() {
        plants = new ArrayList<>();
        insects = new ArrayList<>();
        sprinklers = new ArrayList<>();
        startTime = System.nanoTime();

    }
    public double simulationDays() {
        long elapsedTime = System.nanoTime() - startTime;
        long elapsedHours = TimeUnit.NANOSECONDS.toSeconds(elapsedTime);
        return (double) elapsedHours / 24;
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

   /* public void updateGarden() {
        // Remove dead plants
        plants.removeIf(plant -> plant.getHealth() <= 0);

        // Check for plant-insect interactions
        for (Plant plant : plants) {
            for (Insect insect : insects) {
                if (plant.getHealth() > 0 && insect.getHealth() > 0 && plant.interactsWith(insect)) {
                    plant.setHealth(plant.getHealth() - insect.getDamage());
                    insect.setHealth(insect.getHealth() - plant.getDamage());
                }
            }
        }

        // Water plants with sprinklers
        for (Sprinkler sprinkler : sprinklers) {
            List<Plant> plantsToWater = sprinkler.getPlantsInRange(plants);
            for (Plant plant : plantsToWater) {
                plant.setHealth(plant.getHealth() + 1);
            }
        }
    }*/


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



    public void simulateDay() {
        for (Plant plant : plants) {
            plant.tick();
        }
        for (Insect insect : insects) {
            insect.tick();
        }
        //updateGarden();
        sunlightSystem.simulateSunlight();
        wateringSystem.executeWatering();
    }
}
