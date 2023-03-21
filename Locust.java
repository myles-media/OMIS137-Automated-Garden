public class Locust extends Insects {
    public Locust(String name, int lifespan) {
        super(name, lifespan);
    }
    public void attack(Plant plant) {
        int newHealth = plant.getHealth() - getlifespan();
        plant.setHealth(newHealth);
        System.out.println(getName() + " attacked " + plant.getName() + " and dealt " + getDamageLevel() + " damage!");
    }
}
