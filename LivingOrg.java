import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// New enum class
enum Age {
    YOUNG(1), MATURE(2), ELDER(3);

    private final int value;

    Age(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


// Parent class

abstract class LivingOrg {
    protected String name;
    protected Age age;
    protected boolean isAlive;
    protected String type;
    protected double damage;

    public void grow() {
        if (age == Age.ELDER) {
            isAlive = false;
        } else {
            age = Age.values()[age.ordinal() + 1];
        }
    }

    public boolean checkAlive() {
        if (age == Age.ELDER) {
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

    public Age getAge() {
        return age;
    }

    public double getDamage() {
        return damage;
    }

    public void tick() {
        age = Age.values()[age.ordinal() + 1];
        checkAlive();
    }
}