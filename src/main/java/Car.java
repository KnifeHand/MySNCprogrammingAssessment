public class Car extends Vehicle{

    public String manufacturer;
    public int modelYear;
    public String bodyStyle;
    public String fuel;

    public Car(float identifier,
               float descriptor,
               float weight,
               float width,
               float height,
               String manufacturer,
               int modelYear,
               String bodyStyle,
               String fuel) {

        super(identifier, descriptor, weight, width, height);

        this.manufacturer = manufacturer;
        this.modelYear = modelYear;
        this.bodyStyle = bodyStyle;
        this.fuel = fuel;
    }

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
