class Sensor {
    String sensorType;
    double reading;

    public Sensor(String sensorType) {
        this.sensorType = sensorType;
        this.reading = 0;
    }

    public String getSensorType() {
        return sensorType;
    }

    public double getReading() {
        return reading;
    }

    public void updateReading() {
        // Implement logic to update the sensor reading
    }

    public void displayReading() {
        System.out.println(sensorType + " reading: " + reading);
    }
}
