import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Parent classes

abstract class LivingOrg {
    protected String name;
    public double simulationDays;
    public double age;

    protected double lifespan;
    protected boolean isAlive;
    protected String type;
    protected double damage;

    public void grow() {
        age++;
    }

    private Object simulationDays() {
        return simulationDays;
    }


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

    public double getAge() {
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