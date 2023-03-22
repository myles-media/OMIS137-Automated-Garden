class SunlightSystem {
    Garden garden;
    int sunlightHours;

    public SunlightSystem(Garden garden) {
        this.garden = garden;
        this.sunlightHours = 0;
    }

    public void setSunlightHours(int sunlightHours) {
        this.sunlightHours = sunlightHours;
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
        // Implement logic to adjust sunlight for a plant
    }
}
