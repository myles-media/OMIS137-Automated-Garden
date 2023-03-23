import java.util.HashMap;
import java.util.Map;
//NOTE: Watering System has been redacted from main program. This class has been kept for documentation purposes
class WateringSystem {
    Garden garden;
    Map<Plant, Integer> schedule;

    public WateringSystem(Garden garden) {
        this.garden = garden;
        schedule = new HashMap<>();
    }

    public void waterPlant(Plant plant) {
        double waterRequirement = plant.getWaterRequirement();
        double waterLevel = plant.getWaterLevel();
        if (waterLevel < waterRequirement) {
            double requiredWater = waterRequirement - waterLevel;
            // Add requiredWater units of water to the plant's waterLevel
            plant.setWaterLevel(waterLevel + requiredWater);
        }
    }

    public void updateSchedule(Plant plant, Integer schedule) {
        this.schedule.put(plant, schedule);
    }

    public Map<Plant, Integer> getWateringSchedule() {
        return schedule;
    }

    public void executeWatering() {
        for (Plant plant : garden.plants) {
            waterPlant(plant);
        }
    }

    public void displayWateringSystem() {
        System.out.println("Watering Requirements:");
        System.out.println("Plants:");
        for (Plant plant : garden.plants) {
            System.out.println(plant.getName()+ " has: " + plant.getWaterLevel() + " units of water.");
            double requiredWater = (plant.getWaterRequirement() - plant.getWaterLevel());
            System.out.println("It needs: " + requiredWater + " more units");
        }
    }
}
