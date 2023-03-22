class Plant extends LivingOrg {
    protected double growthRate;
    protected double waterRequirement;
    protected double temperatureRequirement;

    public Plant(String name) {
        this.name = name;
        this.age = 0;
        this.isAlive = true;
        this.type = "Plant";
    }

    @Override
    public void tick() {
        super.tick();
        grow();
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public double getWaterRequirement() {
        return waterRequirement;
    }

    public double getTemperatureRequirement() {
        return temperatureRequirement;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    public void setWaterRequirement(double waterRequirement) {
        this.waterRequirement = waterRequirement;
    }

    public void setTemperatureRequirement(double temperatureRequirement) {
        this.temperatureRequirement = temperatureRequirement;
    }
}