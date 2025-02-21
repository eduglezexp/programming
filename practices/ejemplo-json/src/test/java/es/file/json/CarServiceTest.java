package es.file.json;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarServiceTest {

    CarService carService;
    Car car;

    @BeforeEach
    void before() {
        carService = new CarService();
        car = new Car(3, "marca", "modelo", 10000);
        carService.addCar(car);
    }

    @AfterEach
    void afterEach() {
        carService.deleteCar(car);
        Assertions.assertEquals(2, carService.getCars().size());
    }

    @Test
    void addCarTest() {
        Assertions.assertEquals(3, carService.getCars().size());
    }

    @Test
    void addCarNullTest() {
        boolean result = carService.addCar(null);
        Assertions.assertFalse(result, "El resultado no es el esperado");
    }

    @Test
    void addCarExistTest() {
        Car newCar = new Car(1);
        boolean result = carService.addCar(newCar);
        Assertions.assertFalse(result, "El resultado no es el esperado");
    }

    @Test
    void searchCarTest() {
        Car newCar = carService.search(car.getId());
        Assertions.assertEquals(car, newCar, "El coche no es el esperado");
    }

    @Test
    void searchCarNotExistTest() {
        Car newCar = carService.search(-1);
        Assertions.assertNull(newCar, "El valor del coche no es el esperado");
    }

    @Test
    void searchCarPriceTest() {
        List<Car> cars = carService.searchPrice(20000);
        Assertions.assertEquals(2, cars.size(), "El tamanio de la lista no es el esperado");
    }

    @Test
    void deleteCarNullTest() {
        boolean result = carService.deleteCar(null);
        Assertions.assertFalse(result, "El resultado no es el esperado");
    }
}