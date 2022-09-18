package dat3.cars.api;


import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {
    CarService carService;

    //Security Admin
    @GetMapping("/admin")
    public List<CarResponse> getCarsWithAllInfo(){
        return carService.getCars(true);
    }
    //Security User.
    @GetMapping(path = "/{carId}")
    private CarResponse getCarById(@PathVariable int carId)throws Exception{
        CarResponse response = carService.findCarById(carId, false);
        return response;
    }

    @GetMapping(path = "/admin/{carId}")
    public CarResponse getCarByIdWithAllInfo(@PathVariable int carId) throws Exception{
        CarResponse response = carService.findCarById(carId,true);
        return response;
    }

    public CarController(CarService carService){
        this.carService = carService;
    }

    //Security --> ADMIN ONLY
    @PostMapping //addCar
    public CarResponse addMember(@RequestBody CarRequest body){
        return carService.addCar(body, true); //returner en car
    }

    //Security --> Admin,
    @PutMapping("/{carId}") //rediger objected
    public void editCar(@RequestBody CarRequest body,@PathVariable int carId){
        carService.editCar(body,carId);
    }

    //Security ADMIN
    @PatchMapping("/rentalprice/{carId}/{newPrice}")
    private void setNewPrice(@PathVariable int carId,@PathVariable double newPrice){
        carService.setPricePrDay(carId, newPrice);
    }
    //Security ALL
    @GetMapping
    public List<CarResponse> getCars(){
        return carService.getCars(false);
    }

























}
