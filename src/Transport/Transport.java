package Transport;

public class Transport {
    private String brand;
    private String model;
    private final int year;
    private final String country;
    private String color;
    private int maxSpeed;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setBrand(String brand) {
        if (brand != null || brand.isEmpty() || brand.isBlank()) {
            this.brand = brand;
        }
    }

    public void setModel(String model) {
        if (model!= null || model.isEmpty() || model.isBlank()) {
            this.model = model;
        }
    }

    public void setColor(String color) {
        if (color!= null || color.isEmpty() || color.isBlank()) {
            this.color = model;
        }
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed == 0) {
            this.maxSpeed = 160;
        } else {
            this.maxSpeed = maxSpeed;
        }
    }


    public Transport(String brand, String model, int year, String country, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.country = country;
        this.color = color;

    }
}
