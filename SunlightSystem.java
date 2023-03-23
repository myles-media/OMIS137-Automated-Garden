class SunlightSystem {
    Garden garden;
    int sunlightHours;

    public SunlightSystem(Garden garden) {
        this.garden = garden;
    }

    public int getSunlightHours() {return sunlightHours;}

    public void simulateSunlight() {
        int minSunlightHours = 4;
        int maxSunlightHours = 12;
        sunlightHours = (int) (Math.random() * (maxSunlightHours - minSunlightHours + 1)) + minSunlightHours;
        for (Plant plant : garden.plants) {
            double sunLevel = sunlightHours - plant.getSunlightRequirement();
            plant.setSunlightLevel(sunLevel);
        }
    }

    public void displaySunlightSchedule() {
        System.out.println("Today's sunlight hours: " + getSunlightHours() + " hours");
    }
}
