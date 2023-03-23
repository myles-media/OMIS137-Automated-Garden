class Plant extends LivingOrg {
    private int daysToNextAge;
    private int[] daysToNextAges = {10, 15, Integer.MAX_VALUE};
    protected double waterRequirement;
    protected Age lifespan;
    protected double waterLevel;
    protected double sunlightRequirement;
    protected double sunlightLevel;
    protected double[] sunlightIncrements; // new field for storing sunlight level increments
    protected double[] waterIncrements; // new field for storing water level increments

    public Plant(String name) {
        this.name = name;
        this.waterLevel = 1;
        this.sunlightLevel = 1;
        this.waterRequirement = waterRequirement;
        this.daysToNextAge = daysToNextAges[0];
        age = Age.YOUNG;
        lifespan = Age.ELDER;
        isAlive = true;
        type = "Plant";
        damage = 0;

        // initialize the arrays of random increments for each age stage
        sunlightIncrements = new double[]{0.5, 1.0, 1.5};
        waterIncrements = new double[]{0.1, 0.2, 0.3};
    }

    public void grow() {
        daysToNextAge--;
        if (daysToNextAge <= 0) {
            int currentAgeOrdinal = age.ordinal();
            int maxAgeOrdinal = Age.ELDER.ordinal();

            if (currentAgeOrdinal == maxAgeOrdinal) {
                isAlive = false;
            } else {
                // generate random number for daysToNextAge at the current age stage
                int max = 2;
                int min = 0;
                int range = max - min + 1;
                int rand = (int) (Math.random() * range) + min;
                daysToNextAges[currentAgeOrdinal + 1] = rand;
                age = Age.values()[currentAgeOrdinal + 1];
                daysToNextAge = daysToNextAges[currentAgeOrdinal + 1]; // Set daysToNextAge for the new age stage

                // increment the sunlight and water levels randomly based on the current age stage
                sunlightLevel += sunlightIncrements[currentAgeOrdinal] * Math.random();
                waterLevel += waterIncrements[currentAgeOrdinal] * Math.random();
            }
        }
    }


    private int getDaysToNextAge() {
        int[] daysToNextAge = {10, 15, Integer.MAX_VALUE};
        int currentAgeOrdinal = age.ordinal();
        return daysToNextAge[currentAgeOrdinal];
    }


    @Override
    public void tick() {
        super.tick();
        grow();
    }


    public double getWaterRequirement() {
        return waterRequirement;
    }

    public double getWaterLevel() {
        return waterLevel;
    }


    public double getSunlightRequirement() {
        return sunlightRequirement;
    }

    public double getSunlightLevel() {
        return sunlightRequirement;
    }


    public void setWaterRequirement(double waterRequirement) {
        this.waterRequirement = waterRequirement;
    }

    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public void setSunlightRequirement(double sunlightRequirement) {
        this.sunlightRequirement = sunlightRequirement;
    }

    public void setSunlightLevel(double sunlightLevel) {
        this.sunlightLevel = sunlightLevel;
    }

    public void resetSunlightAndWaterLevels(int sunlightHours) {
        this.sunlightLevel = sunlightHours;
        this.waterLevel = 0;
    }
}