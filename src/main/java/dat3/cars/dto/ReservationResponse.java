package dat3.cars.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.cars.entity.Reservation;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

//---------------Lombok
@Setter
@Getter
@AllArgsConstructor
//TODO dont work, @NoArgsConstructor
@Builder
//TODO dont work; @JsonInclude(JsonInclude.Include.NON_NULL);
//---------------Lombok


@Entity //Maven: Det skal ned i databasen / laver en tabel klassenavnet
public class ReservationResponse {
    //---------------Fields / attributter.
    @Id
    int id;
    String memberUsername;
    int carId;
    String carBrand;
    @JsonFormat(pattern = "dd-mm-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate rentalData;
    //---------------Fields / attributter

    //---------------Constructor.
    //TODO der er et problem med Constructor
    public ReservationResponse(Reservation r ) {
        this.id = id;
        this.memberUsername = memberUsername;
        this.carId = carId;
        this.carBrand = carBrand;
        this.rentalData = rentalData;
    }
    //TODO der er et problem med Constructor oven over.
    public ReservationResponse() {
    }
    //---------------Constructor.

}
