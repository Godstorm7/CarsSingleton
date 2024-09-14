import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private static CarFactory instance;
    private int totalCars;
    private Car[] cars;
    private int[] quantidades;
    private CarFactory() {
        cars = new Car[0];
        quantidades = new int[0];
    }

    public static CarFactory getInstance(){
        if (instance == null){
            instance = new CarFactory();
        }
        return instance;
    }
    public Car buildCar(String model){
        Car car = new Car();
        car.setModel(model);
        totalCars++;

        boolean achado = false;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getModel().equals(model)) {
                quantidades[i]++;
                achado = true;
                break;
            }
        }
        if (!achado) {
            Car[] newCars = new Car[cars.length + 1];
            int[] newQuantidades = new int[quantidades.length + 1];
            for (int i = 0; i < cars.length; i++) {
                newCars[i] = cars[i];
                newQuantidades[i] = quantidades[i];
            }
            newCars[cars.length] = car;
            newQuantidades[cars.length] = 1;
            cars = newCars;
            quantidades = newQuantidades;
            }

        System.out.println("Carro do modelo " + car.getModel() + " criado!");
        return car;
    }
    public String getTotal(){
        return "Total Carros: "+ totalCars;
    }
    private String modeloMaisPopular() {
        int maxQuantity = 0;
        String maisPopular = null;
        for (int i = 0; i < quantidades.length; i++) {
            if (quantidades[i] > maxQuantity) {
                maxQuantity = quantidades[i];
                maisPopular = cars[i].getModel();
            }
        }
        return maisPopular;
    }
    public void geraRelatorio() {
        System.out.println(" ");
        System.out.println("Relatorio de Vendas :");
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].getModel() + ": " + quantidades[i]);
        }
        String mostPopularModel = modeloMaisPopular();
        System.out.println("Carro Mais Popular: " + mostPopularModel);
    }
}