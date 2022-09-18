package dat3.cars.dto;


import dat3.cars.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
Car request object (hele classen)
Data Transfer Object
An object that carries data between processes in order to reduce the number of method calls.
*/

//---------------Lombok.
@Getter //-- Auto generer. programmet ved de er der.
@Setter //-- Auto generer. programmet ved de er der.
@AllArgsConstructor //-- En Constructor der tager all augmenter.
@NoArgsConstructor //-- En Constructor uden augmenter.
//---------------Lombok

// DTO class
public class CarRequest {
    //---------------Fields / attributter.
    String brand;
    String model;
    double pricePrDay;
    double bestDiscount;
    //---------------Fields / attributter

    //---------------Constructor.
    public static Car getCarEntity(CarRequest cr){
        return  Car.builder()  //return Car object
                .brand(cr.brand)
                .model(cr.model)
                .pricePrDay(cr.pricePrDay)
                .bestDiscount(cr.bestDiscount)
                .build();
    }
    //---------------Constructor.

    //---------------Constructor.
    // Car Request to get one car.
    public CarRequest(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
        this.bestDiscount = car.getBestDiscount();
    }
    //---------------Constructor.

}
