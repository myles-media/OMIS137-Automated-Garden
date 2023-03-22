class SunlightSystem {
    Garden garden;
    int sunlightHours;

    public SunlightSystem(Garden garden) {
        this.garden = garden;
        this.sunlightHours = (int) (8 + Math.random() * 4); // Simulate 8 to 12 hours of sunlight
    }

    public int getSunlightHours() {
        return sunlightHours;
    }

    public void simulateSunlight() {
        for (Plant plant : garden.plants) {
            adjustSunlightForPlant(plant);
        }
    }

    public void adjustSunlightForPlant(Plant plant) {
        // Implement logic to adjust sunlight for a plant based on sunlightRequirement
    }

    public void displaySunlightSchedule() {
        System.out.println("Today's sunlight hours: " + getSunlightHours() + " hours");
    }
}
