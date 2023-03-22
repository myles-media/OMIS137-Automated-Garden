class Insect extends LivingOrg {
    protected double damage;
    protected double reproductionRate;

    public Insect(String name) {
        this.name = name;
        this.age = 0;
        this.isAlive = true;
        this.type = "Insect";
    }

    @Override
    public void tick() {
        super.tick();
        reproduce();
    }

    public void reproduce() {
        int offspring = (int) Math.floor(reproductionRate);
        for (int i = 0; i < offspring; i++) {
            // You will need to update the way new insects are added to the garden.
            // The current implementation does not support this.
        }
    }

    public double getDamage() {
        return damage;
    }

    public double getReproductionRate() {
        return reproductionRate;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setReproductionRate(double reproductionRate) {
        this.reproductionRate = reproductionRate;
    }
}