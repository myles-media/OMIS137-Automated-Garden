class Mint extends Plant {
    public Mint(String name) {
        super(name);
        this.growthRate = 1.2;
        this.waterRequirement = 0.8;
        this.sunlightRequirement = 7;
        this.lifespan = 3 * 365;
    }
}