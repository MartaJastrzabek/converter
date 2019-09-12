package service;

public class MetricConverter {

    private double meters;
    private double centimeters;
    private double millimeters;
    private MetricType type;

    public void setType(String type) {
        this.type = MetricType.valueOf(type);
    }

    public double getMeters() {
        return meters;
    }

    public void setMeters(double meters) {
        this.meters = meters;
    }

    public double getCentimeters() {
        return centimeters;
    }

    public void setCentimeters(double centimeters) {
        this.centimeters = centimeters;
    }

    public double getMillimeters() {
        return millimeters;
    }

    public void setMillimeters(double millimeters) {
        this.millimeters = millimeters;
    }

    private double convertMillimetersToMetre() {
        return millimeters / 1000;
    }

    private double convertMillimetersToCentimeters() {
        return millimeters / 10;
    }

    private double convertMetresToMillimeters() {
        return meters * 1000;
    }

    private double convertMetresToCentimetres() {
        return meters * 100;
    }

    private double convertCentimetersToMillimeters() {
        return centimeters * 10;
    }

    private double convertCentimetersToMeters() {
        return centimeters / 100;
    }

    public void calculate() {
        switch (type) {
            case METERS:
                centimeters = convertMetresToCentimetres();
                millimeters = convertMetresToMillimeters();
                break;
            case CENTIMETRES:
                meters = convertCentimetersToMeters();
                millimeters = convertCentimetersToMillimeters();
                break;
            case MILLIMETERS:
                meters = convertMillimetersToMetre();
                centimeters = convertMillimetersToCentimeters();
                break;
        }
    }
}
