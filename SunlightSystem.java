class SunlightSystem {
    Garden garden;
    int sunlightHours;

    public SunlightSystem(Garden garden) {
        this.garden = garden;
        this.sunlightHours = (int) (4 + Math.random() * 4); // Simulate 4 to 8 hours of sunlight
    }

    public int getSunlightHours() {
        return sunlightHours;
    }

    public void simulateSunlight() {
        for (Plant plant : garden.plants) {
            double sunLevel = getSunlightHours() - plant.getSunlightRequirement();
            plant.setSunlightLevel(sunLevel);
        }
    }

    public void displaySunlightSchedule() {
        System.out.println("Today's sunlight hours: " + getSunlightHours() + " hours");
    }
}
