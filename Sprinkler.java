import java.awt.*;

class Sprinkler {
    Point position;
    double range;
    double waterOutput;
    boolean isActive;

    public Sprinkler(Point position, double range, double waterOutput) {
        this.position = position;
        this.range = range;
        this.waterOutput = waterOutput;
        this.isActive = false;
    }

    public void activate() {
        isActive = true;
    }

    public void deactivate() {
        isActive = false;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    public void setRange(double range) {
        this.range = range;
    }

    public void setWaterOutput(double waterOutput) {
        this.waterOutput = waterOutput;
    }
}