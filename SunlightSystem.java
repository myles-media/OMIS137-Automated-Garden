class SunlightSystem {
    Garden garden;
    int sunlightHours;

    public SunlightSystem(Garden garden) {
        this.garden = garden;
    }

    public int getSunlightHours() {return sunlightHours;}

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
