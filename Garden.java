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
        wateringSystem = new WateringSystem(this);
        sunlightSystem = new SunlightSystem(this);
    }

    public WateringSystem getWateringSystem() {
        return wateringSystem;
    }

    public SunlightSystem getSunlightSystem() {
        return sunlightSystem;
    }


    public double simulationDays() {
        long elapsedTime = System.nanoTime() - startTime;
        long elapsedHours = TimeUnit.NANOSECONDS.toSeconds(elapsedTime);
        double days = (double) elapsedHours / 24;
        return Math.round(days * 100.0) / 100.0;
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
            plant.grow();
        }
        for (Insect insect : insects) {
            if (insect.getName().equals("Locust")) {
                // Locust evolve faster than other insects
                insect.age = Age.values()[(insect.getAge().ordinal() + 2) % Age.values().length];
            } else if (insect.getName().equals("Worm")) {
                // Worms evolve faster than other insects
                insect.age = Age.values()[(insect.getAge().ordinal() + 4) % Age.values().length];
            } else {
                // Other insects evolve normally
                insect.grow();
            }
        }
        sunlightSystem.simulateSunlight();
        wateringSystem.executeWatering();
    }

    //public String getDaySummary() {
        // Return a string that represents the summary of what happened in the garden during the simulation.
        // This should include plant growth, insect activity, watering, and sunlight.
    }

