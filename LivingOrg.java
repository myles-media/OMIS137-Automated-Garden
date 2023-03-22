import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Parent classes

abstract class LivingOrg {
    protected String name;
    protected int age;
    protected int lifespan;
    protected boolean isAlive;
    protected String type;

    public void grow() {}

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

    public void tick() {
        age++;
        checkAlive();
    }
}