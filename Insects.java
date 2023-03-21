public abstract class Insects extends LivingOrg {
    private String name;
    private int lifespan;
    private int damageLevel;

    public Insects(String name, int lifespan) {
        //super(name, lifespan, damageLevel);
        this.name = name;
        this.lifespan = lifespan;
        this.damageLevel = damageLevel;
    }

    public String getName() {
        return name;
    }

    public int getLifespan() {
        return lifespan;
    }
}
