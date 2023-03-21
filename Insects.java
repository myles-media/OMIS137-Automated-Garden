public abstract class Insects extends LivingOrg {
    private String name;
    private int lifespan;

    public Insects(String name, int lifespan) {
        super(name, lifespan);
    }

    public String getName() {
        return name;
    }

    public int getLifespan() {
        return lifespan;
    }
}
