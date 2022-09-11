package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.entity.Car;
import dat3.cars.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

// Injected my carRepository.
//Al forretnings logikken
//Kan lave ting
@Service
public class CarService {
    CarRepository carRepository;

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    //front -> controller -> Service ->
    public CarResponse addCar(CarRequest carRequest, boolean includeALL){
        Car newCar = CarRequest.getCarEntity(carRequest);
        newCar = carRepository.save(newCar);
        return new CarResponse(newCar, includeALL); //return an entity class
    }


    public void editCar(CarRequest body, int carId){
        Car car = carRepository.findById(carId).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Car wit this Id don't exist"));
        car.setBrand(body.getBrand());
        car.setModel(body.getModel());
        car.setPricePrDay(body.getPricePrDay());
        car.setBestDiscount(body.getBestDiscount());
        carRepository.save(car);
    }

    public List<CarResponse> getCars(boolean includeALL){
        List<Car> cars = carRepository.findAll();
        List<CarResponse> response = new ArrayList<>();
        for(Car car : cars){
            response.add(new CarResponse(car,includeALL));
        }
        return response;
    }

    public CarResponse findCarById(int id, boolean includeALL) throws Exception{
        Car found = carRepository.findById(id).orElseThrow(()->
                new ResponseStatusException((HttpStatus.NOT_FOUND), "ca not found"));
        return new CarResponse(found, includeALL);
    }

    public void setPricePrDay(int carId, double price){
        Car car = carRepository.findById(carId).orElseThrow(()->
                new ResponseStatusException((HttpStatus.BAD_REQUEST),"Member with this username already exist"));
        car.setPricePrDay(price);
        carRepository.save(car);
    }

}
