class Cilantro extends Plant {
    public Cilantro(String name) {
        super(name);
        this.growthRate = 1.5;
        this.waterRequirement = 0.6;
        this.temperatureRequirement = 6;
        this.lifespan = 2 * 365;
    }
}