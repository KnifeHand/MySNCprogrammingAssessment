public class Boat extends Vehicle {
    public String power;
    public float draft;
    public String manufacturer;

    public Boat(String identifier,
                String descriptor,
                float weight,
                float width,
                float height,
                float length,
                String power,
                float draft,
                String manufacturer) {

        super(identifier, descriptor, weight, width, height, length);

        this.power = power;
        this.draft = draft;
        this.manufacturer = manufacturer;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public float getDraft() {
        return draft;
    }

    public void setDraft(float draft) {
        this.draft = draft;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
