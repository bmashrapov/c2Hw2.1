import Transport.Car;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car lada = new Car("Lada", "Granta", 1.7, 2015, "жёлтый", "Россия");
        Car audi = new Car("Audi", "А8 50 L TDI", 3.0, 2020, "чёрный", "Германия");
        Car bmw = new Car("BMW", "Z8", 3.0, 2021, "чёрный", "Германия");
        Car kia = new Car("Kia", "Sportage", 2.0, 2018, "красный", "Южная Корея");
        Car hyundai = new Car("Hyundai", "Avante", 1.6, 2016, "оранжевый", "Южная Корея");
        audi.setRegistrationNumber("a321aa138");
        System.out.println(audi.isCorrectNumber());
        audi.setTransmission("механика");
        audi.setKey(new Car.Key(true,true));
        audi.setInsurance(new Car.Insurance(LocalDate.now(),30000,"321654987"));
        audi.getInsurance().checkExpireDate();
        audi.getInsurance().checkNumber();
        printInformation(lada);
        printInformation(audi);
        printInformation(bmw);
        printInformation(kia);
    }

    private static void printInformation(Car car) {
        System.out.println(car.getBrand() + car.getModel() +
                ", год выпуска: " + car.getYear() +
                ", страна сборки: " + car.getCountry() +
                ", цвет машины: " + car.getColor() +
                ", объем двигателя: " + car.getEngineVolume() +
                ", коробка передач: " + car.getTransmission() +
                ", тип кузова: " + car.getTypeOfBody() +
                ", регистрационный номер: " + car.getRegistrationNumber() +
                ", количство мест: " + car.getSeatCount() +
                "," + (car.isSummerTyres() ? "летняя" : "зимняя") + " резина"
                + "," + (car.getKey().isAutoStart() ? "безключевой доступ" : "ключевой доступ")
                + "," + (car.getKey().isRemoteStart() ? "удаленный запуск" : "стандартный запуск")
                + ", номер страховки: " + car.getInsurance().getNumber()
                + ", стоимость страховки: " + car.getInsurance().getCost()
                + ", срок годности: " + car.getInsurance().getExpireDay());
    }
}