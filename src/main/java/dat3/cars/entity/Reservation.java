package dat3.cars.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

//----------------Lombok.
@Getter //-- Auto generer. programmet ved de er der.
@Setter //-- Auto generer. programmet ved de er der.
@AllArgsConstructor //-- En Constructor der tager all augmenter.
@NoArgsConstructor //-- En Constructor uden augmenter.
@Builder //-- Skal have en @AllArgsConstructor for at det skal fungerer. (@Builder kan give problemer ved nedarv)
//-----------------Lombok

@Entity
public class Reservation {

    //---------------Fields / attributter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    Member member;
    @ManyToOne
    Car car;
    @CreationTimestamp
    LocalDateTime reservationDate;
    LocalDate rentalDate;
    //---------------Fields / attributter

    //---------------Constructor.
    public Reservation (Member member, Car car, LocalDate rentalDate){
        this.member = member;
        this.car = car;
        this.rentalDate = rentalDate;
    }
    //---------------Constructor.
}
