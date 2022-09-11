package dat3.cars.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

//-----------------Lombok
@Getter //-- Auto generer. programmet ved de er der.
@Setter //-- Auto generer. programmet ved de er der.
@AllArgsConstructor //-- En Constructor der tager all augmenter.
@NoArgsConstructor //-- En Constructor uden augmenter.
@Builder //-- Skal have en @AllArgsConstructor for at det skal fungerer. (@Builder kan give problemer ved nedarv)
//-----------------Lombok
@Entity
public class Rental
{
    //---------------Fields / attributter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //TODO Skal disse også være her, eftersom de er lavet i Reservation
    @ManyToOne
    Member member;
    @ManyToOne
    Car car;
    @CreationTimestamp
    LocalDateTime reservationDate;
    LocalDate rentalDate;
    //---------------Fields / attributter

    //---------------Constructor.
    public Rental(Member member, Car car, LocalDateTime reservationDate, LocalDate rentalDate) {
        this.member = member;
        this.car = car;
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
    }
    //---------------Constructor.
}
