package dat3.cars.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.xml.bind.v2.TODO;
import dat3.cars.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
/*
Data Transfer Object
An object that carries data between processes in order to reduce the number of method calls.
*/

//---------------Lombok
@Getter //-- Auto generer. programmet ved de er der.
@Setter //-- Auto generer. programmet ved de er der.
@AllArgsConstructor //-- En Constructor der tager all augmenter.
@NoArgsConstructor //-- En Constructor uden augmenter.
@JsonInclude(JsonInclude.Include.NON_NULL) //Der kommer kun det med der ikke er NUll,
//---------------Lombok
//Den afspejler det der skal retur
public class CarResponse {
    //---------------Fields / attributter
    int id;
    String brand;
    String model;
    double pricePrDay;
    double BestDiscount; // to allow for Null.
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING) // ADMIN info
    LocalDateTime created;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;
    //---------------Fields / attributter

    //---------------Constructor.
    public CarResponse(Car carEntity, boolean inccludeAll){
        this.id = carEntity.getId();
        this.brand = carEntity.getBrand();
        this.model = carEntity.getModel();
        this.pricePrDay = carEntity.getPricePrDay();
        //TODO Hvad gør denne if()
        if(inccludeAll) {
            BestDiscount = carEntity.getBestDiscount();
            this.created = carEntity.getCreated();
            this.edited = carEntity.getEdited();
        }
    }
    //---------------Constructor.
}
