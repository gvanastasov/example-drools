package example.drools.models;

public class Product {
    private String name;
    private boolean isAvailable = false;

    public Product(String name, boolean isAvailable) {
        this.setName(name);
        this.setAvailable(isAvailable);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
