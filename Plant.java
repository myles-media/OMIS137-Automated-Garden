class Plant extends LivingOrg {
    private int daysToNextAge;
    protected double waterRequirement;
    protected Age lifespan;
    protected double waterLevel;
    protected double sunlightRequirement;
    protected double sunlightLevel;

    public Plant(String name) {
        this.name = name;
        this.waterLevel = 0;
        this.sunlightLevel = 0;
        this.daysToNextAge = daysToNextAge;
        age = Age.YOUNG;
        lifespan = Age.ELDER;
        isAlive = true;
        type = "Plant";
        damage = 0;
    }
    public void grow() {
        daysToNextAge--;
        if (daysToNextAge <= 0) {
            if (age == Age.ELDER) {
                isAlive = false;
            } else {
                age = Age.values()[age.ordinal() + 1];
                daysToNextAge = getDaysToNextAge(); // Set daysToNextAge for the new age stage
            }
        }
    }
    private int getDaysToNextAge() {
        switch (age) {
            case YOUNG:
                return 10; // Takes 10 days to mature
            case MATURE:
                return 3; // Takes 3 days to become elder
            case ELDER:
                return Integer.MAX_VALUE; // Never evolves past elder
            default:
                return 0; // Invalid age
        }
    }



    @Override
    public void tick() {
        super.tick();
        //grow();
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
    public void setSunlightLevel(double sunlightLevel) {this.sunlightLevel = sunlightLevel;}
}
