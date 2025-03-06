package es.ies.puerto.file;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TrabajoJson {
    static  ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.setColor("gris");
        myCar.setType("automovil");
        Set<Car> cars = new HashSet<>();
        cars.add(myCar);
        cars.add(myCar);
        try {
            objectMapper.writeValue(new File("src/main/resources/car.json"), cars);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}