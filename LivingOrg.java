public abstract class LivingOrg {
    protected String name;
    protected int lifespan;
    protected int age;

    public LivingOrg(String name, int lifespan) {
        this.name = name;
        this.lifespan = lifespan;
        this.age = 0;
    }

    public void grow() {
        this.age++;
    }

    public boolean isAlive() {
        return this.age < this.lifespan;
    }

    public abstract void interact();
}

