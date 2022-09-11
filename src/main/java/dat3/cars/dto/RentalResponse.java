package dat3.cars.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

//---------------Lombok.
@Getter //-- Auto generer. programmet ved de er der.
@Setter //-- Auto generer. programmet ved de er der.
@AllArgsConstructor //-- En Constructor der tager all augmenter.
@NoArgsConstructor //-- En Constructor uden augmenter.
//---------------Lombok.

@Entity //Maven: Det skal ned i databasen / laver en tabel klassenavnet Rental.
public class RentalResponse {
    @Id
    int id;

}
