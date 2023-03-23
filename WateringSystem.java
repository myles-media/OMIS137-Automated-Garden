import java.util.HashMap;
import java.util.Map;

class WateringSystem {
    Garden garden;
    Map<Plant, Integer> schedule;

    public WateringSystem(Garden garden) {
        this.garden = garden;
        schedule = new HashMap<>();
    }

    public void waterPlant(Plant plant) {
        // Implement watering logic here
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

    public void displayWateringSchedule() {
        for (Plant plant : garden.plants) {
            System.out.println("The " + plant + "plant requires: " + plant.waterRequirement + " units of water");
        }
    }
}