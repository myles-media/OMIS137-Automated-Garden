class Plant extends LivingOrg {
    protected double waterRequirement;
    protected double waterLevel;
    protected double sunlightRequirement;
    protected double sunlightLevel;

    public Plant(String name) {
        this.name = name;
        this.isAlive = true;
        this.type = "Plant";
        this.damage = 0;
    }
    protected enum PlantAge {
        SEEDLING("Seedling"),
        YOUNG("Young"),
        MATURE("Mature"),
        ELDER("Elder");

        private final String name;

        PlantAge(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
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

    public double getSunlightRequirement() {
        return sunlightRequirement;
    }


    public void setWaterRequirement(double waterRequirement) {
        this.waterRequirement = waterRequirement;
    }

    public void setSunlightRequirement(double sunlightRequirement) {
        this.sunlightRequirement = sunlightRequirement;
    }
}
