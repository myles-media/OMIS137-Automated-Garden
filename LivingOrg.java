import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Parent classes

abstract class LivingOrg {
    protected String name;
    public double simulationDays;
    public int age;

    protected enum age{
        YOUNG("Young"),
        MATURE("Mature"),
        ELDER("Elder");
        private final String name;

        age(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    protected int lifespan;
    protected boolean isAlive;
    protected String type;
    protected double damage;

    /*public void grow() {
        int daysElapsed = (double) simulationDays();
        int daysPerStage = lifespan / age.values().length;

        int currentStage = age.ordinal();
        int nextStage = currentStage + daysElapsed / daysPerStage;

        if (nextStage >= age.values().length) {
            age = age.values()[age.values().length - 1];
        } else {
            age = age.values()[nextStage];
        }
    }*/



    public boolean checkAlive() {
        if (age >= lifespan) {
            isAlive = false;
        }
        return isAlive;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public double getDamage() {
        return damage;
    }

    public void tick() {
        age++;
        checkAlive();
    }
}