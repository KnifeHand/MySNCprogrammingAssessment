/**
 * This class creates a Car object that extends from the Vehicle class attributes.
 *
 * author - Matt Hurt
 */

public class Car extends Vehicle{
    // Properties
    private String manufacturer, bodyStyle, fuel;
    private int modelYear;

    public Car(String identifier,
               String descriptor,
               float weight,
               float width,
               float height,
               float length,
               String manufacturer,
               int modelYear,
               String bodyStyle,
               String fuel) {

        super(identifier, descriptor, weight, width, height, length);

        this.manufacturer = manufacturer;
        this.modelYear = modelYear;
        this.bodyStyle = bodyStyle;
        this.fuel = fuel;
    }
    // Getters and Setters
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
