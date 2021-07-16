public class Vehicle {
    // Create class attributes
    public float identifier;
    public float descriptor;
    public float weight;
    public float width;
    public float height;

    // Vehicle constructor
    public Vehicle(float identifier,
                   float descriptor,
                   float weight,
                   float width,
                   float height) {
        
        this.identifier = identifier;
        this.descriptor = descriptor;
        this.weight = weight;
        this.width = width;
        this.height = height;
    }

    public float getIdentifier() {
        return identifier;
    }

    public void setIdentifier(float identifier) {
        this.identifier = identifier;
    }

    public float getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(float descriptor) {
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
