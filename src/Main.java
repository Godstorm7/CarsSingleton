public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = CarFactory.getInstance();
        carFactory.buildCar("Sedan");
        carFactory.buildCar("SUV");
        carFactory.buildCar("Sport");
        carFactory.buildCar("Sedan");
        carFactory.buildCar("Sport");
        carFactory.buildCar("Sport");

        carFactory.geraRelatorio();
    }
}