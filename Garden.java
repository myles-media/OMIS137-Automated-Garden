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
        int days = (int) elapsedHours / 24;
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
        for (Plant plant : plants) {
            System.out.println(plant.getWaterLevel() + " - Water Level: " + plant.getWaterLevel());
        }
        for (Plant plant : plants) {
            System.out.println(plant.getSunlightLevel() + " - Sunlight Level: " + plant.getSunlightLevel());
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
        Map<String, Integer> plantEvolutionRates = new HashMap<>();
        plantEvolutionRates.put("Lemongrass", 1);
        plantEvolutionRates.put("Cilantro", 2);
        plantEvolutionRates.put("Basil", 3);
        plantEvolutionRates.put("Mint", 4);

        Map<String, Integer> insectEvolutionRates = new HashMap<>();
        insectEvolutionRates.put("Locust", 1);
        insectEvolutionRates.put("Worm", 2);
        insectEvolutionRates.put("Spider Mite", 3);
        insectEvolutionRates.put("Beetle", 4);

        int minEvolutionRate = 1;
        int maxEvolutionRate = 4;

        int plantEvolutionRate;
        int insectEvolutionRate;

        for (Plant plant : plants) {
            plantEvolutionRate = plantEvolutionRates.getOrDefault(plant.getName(), 1);
            insectEvolutionRate = insectEvolutionRates.getOrDefault(plant.getName(), 1);

            int rand = (int) (Math.random() * (maxEvolutionRate - minEvolutionRate + 1)) + minEvolutionRate;
            if (plantEvolutionRate > rand) {
                plant.age = Age.values()[(plant.getAge().ordinal() + 1) % Age.values().length];
            }
            plant.grow();
        }

        for (Insect insect : insects) {
            plantEvolutionRate = plantEvolutionRates.getOrDefault(insect.getName(), 1);
            insectEvolutionRate = insectEvolutionRates.getOrDefault(insect.getName(), 1);

            int rand = (int) (Math.random() * (maxEvolutionRate - minEvolutionRate + 1)) + minEvolutionRate;
            if (insectEvolutionRate > rand) {
                insect.age = Age.values()[(insect.getAge().ordinal() + 1) % Age.values().length];
            }
            insect.grow();
        }

        sunlightSystem.simulateSunlight();
        wateringSystem.executeWatering();
    }
}


//public String getDaySummary() {
        // Return a string that represents the summary of what happened in the garden during the simulation.
        // This should include plant growth, insect activity, watering, and sunlight.


