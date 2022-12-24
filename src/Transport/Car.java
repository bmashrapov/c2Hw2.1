package Transport;

import java.time.LocalDate;

public class Car {
    private final String brand;
    private final String model;
    private double engineVolume;
    private final int year;
    private String color;
    private final String country;
    private String transmission;
    private final String typeOfBody;
    private String registrationNumber;
    private final int seatCount;
    private boolean summerTyres;
    private Key key;
    private Insurance insurance;


    public Car(String brand,
               String model,
               double engineVolume,
               int year,
               String color,
               String country,
               String typeOfBody,
               int seatCount,
               String transmission,
               String registrationNumber,
               boolean summerTyres,
               Insurance insurance,
               Key key) {
        if (brand == null || brand.isEmpty()) {
            brand = "default";
        }
        this.brand = brand;
        if (model == null || model.isEmpty()) {
            model = "default";
        }
        this.model = model;
        if (engineVolume <= 0) {
            engineVolume = 1.5;
        }
        this.engineVolume = engineVolume;
        if (year <= 0) {
            year = 2000;
        }
        this.year = year;
        if (color == null || color.isEmpty()) {
            color = "белый";
        }
        this.color = color;
        if (country == null || country.isEmpty()) {
            country = "default";
        }
        this.country = country;
        if (transmission == null || transmission.isEmpty()) {
            this.transmission = "МКПП";
        } else {
            this.transmission = transmission;
        }
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            this.registrationNumber = "x000xx000";
        } else {
            this.registrationNumber = registrationNumber;
        }
        this.summerTyres = false;
        if (typeOfBody == null || typeOfBody.isEmpty()) {
        this.typeOfBody = "седан";
        } else {
        this.typeOfBody = typeOfBody;
        }
        if (seatCount == 0) {
        this.seatCount = 4;
        } else {
          this.seatCount = seatCount;
         }
        if (key == null) {
            this.key = new Key();
        } else {
            this.key=key;
        }
        if (insurance == null) {
            this.insurance = new Insurance();
        } else {
            this.insurance=insurance;
        }
    }
    public Car(String brand,
               String model,
               double engineVolume,
               int year,
               String color,
               String country) {
        this(brand, model,engineVolume,year, color,country, "седан",4,"механка","x000xx000",true, new Insurance(), new Key());
    }

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

    public String getTypeOfBody() {
        return typeOfBody;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null) {
            this.registrationNumber = "x000xx000";
        } else {
            this.registrationNumber = registrationNumber;
        }
        this.registrationNumber = registrationNumber;
    }

    public boolean isSummerTyres() {
        return summerTyres;
    }

    public void setSummerTyres(boolean summerTyres) {
        summerTyres = summerTyres;
    }

    public void changeTyres() {
        summerTyres = !summerTyres;
    }

    public boolean isCorrectNumber() {
        //x000xx000
        if (registrationNumber.length() != 9) {
            return false;
        }
        char[] chars = registrationNumber.toCharArray();
        if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
            return false;
        }
        return Character.isDigit(chars[1]) && Character.isDigit(chars[2]) && Character.isDigit(chars[3]) && Character.isDigit(chars[6]) && Character.isDigit(chars[7]) && Character.isDigit(chars[8]);
    }
    public static class Key{
        private final boolean remoteStart;
        private final boolean autoStart;

        public Key(boolean remoteStart, boolean autoStart) {
            this.remoteStart = remoteStart;
            this.autoStart = autoStart;
        }
        public Key() {
            this(false, false);
        }

        public boolean isRemoteStart() {
            return remoteStart;
        }

        public boolean isAutoStart() {
            return autoStart;
        }
    }

    public static class Insurance {
        private final LocalDate expireDay;
        private final double cost;
        private final String number;

        public Insurance() {
            this(null, 10000, null);
        }

        public LocalDate getExpireDay() {
            return expireDay;
        }

        public double getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }

        public Insurance(LocalDate expireDay, double cost, String number) {
            if (expireDay == null) {
                this.expireDay = LocalDate.now().plusDays(365);
            } else {
                this.expireDay = expireDay;
            }
            this.cost = cost;
            if (number == null) {
                this.number = "123456789";
            } else {
                this.number = number;
            }
        }

        public void checkExpireDate() {
            if (expireDay.isBefore(LocalDate.now()) || expireDay.isEqual(LocalDate.now())) {
                System.out.println("Нужно ехать продлевать страховку");
            }
        }

        public void checkNumber() {
            if (number.length() != 9) {
                System.out.println("Номер некорректный");
            }
        }


    }


}
