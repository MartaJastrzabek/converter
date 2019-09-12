package service;

public class WeightConverter {

    private WeightType type;
    private double kilograms;
    private double grams;
    private double milligrams;

    public WeightType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = WeightType.valueOf(type);
    }

    public double getKilograms() {
        return kilograms;
    }

    public void setKilograms(double kilograms) {
        this.kilograms = kilograms;
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }

    public double getMilligrams() {
        return milligrams;
    }

    public void setMilligrams(double milligrams) {
        this.milligrams = milligrams;
    }

    private double convertKilogramsToGrams() {
        return kilograms * 1000;
    }

    private double convertKilogramsToMilligrams() {
        return kilograms * 1000000;
    }

    private double convertGramsToKilograms() {
        return grams / 1000;
    }

    private double convertGramsToMilligrams() {
        return grams * 1000;
    }

    private double convertMilligramsToKilograms() {
        return milligrams / 1000000;
    }

    private double convertMilligramsToGrams() {
        return milligrams / 1000;
    }

    public void calculate() {
        switch (type) {
            case GRAMS:
                kilograms = convertGramsToKilograms();
                milligrams = convertGramsToMilligrams();
                break;
            case KILOGRAMS:
                grams = convertKilogramsToGrams();
                milligrams = convertKilogramsToMilligrams();
                break;
            case MILLIGRAMS:
                grams = convertMilligramsToGrams();
                kilograms = convertMilligramsToKilograms();
                break;
        }
    }
}
