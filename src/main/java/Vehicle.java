/**
 * This class facilitates the creation of a vehicle object with all of the
 * appropriate attributes of the class.
 *
 * @author - Matt Hurt
 */

public class Vehicle {
    // Create class attributes
    private String identifier, descriptor;
    private float weight, width, height, length;

    // Vehicle constructor
    public Vehicle(String identifier, String descriptor, float weight, float width,
                   float height, float length) {

        this.identifier = identifier;
        this.descriptor = descriptor;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    // Getters and Setters
    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
