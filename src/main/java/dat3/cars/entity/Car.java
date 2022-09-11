package dat3.cars.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//---------------Lombok
@Getter //-- Auto generer. programmet ved de er der.
@Setter //-- Auto generer. programmet ved de er der.
@AllArgsConstructor //-- En Constructor der tager all augmenter.
@NoArgsConstructor //-- En Constructor uden augmenter.
@Builder //-- Skal have en @AllArgsConstructor for at det skal fungerer. (@Builder kan give problemer ved nedarv).
@ToString //-- (Default to String)
@EqualsAndHashCode  //-- When performance becomes important, never set like this. (default to HAS-Code)Men skal ikke bruge denne Annotation hvis man vil performance optimerer
//---------------Lombok

@Entity //Maven: Det skal ned i databasen / laver en tabel klassenavnet Car
public class Car {
  //---------------Fields / attributter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;
  @Column(length = 50,nullable = false) //@Column's krav til databasen (det er de specific krav til kolonnen).
  private String brand;
  @Column(length= 50, nullable = false) //@Column's krav til databasen (det er de specific krav til kolonnen).
  private String model;
  double pricePrDay;
  //Best discount price (percent for pricePrDay) an admin can offer
  double bestDiscount;

  @CreationTimestamp
  LocalDateTime created; //LocalDateTime is a final class: does not store.

  @UpdateTimestamp
  LocalDateTime edited; //LocalDateTime is a final class: does not store.
  //---------------Fields / attributter

  //---------------Reservation class
  @OneToMany(mappedBy = "car")
  List<Reservation> reservations = new ArrayList<>();
  public void addReservation(Reservation res){
    reservations.add(res);
    res.setCar(this);
  }
  //---------------Reservation class

  //---------------Constructor.
  public Car(String brand, String model, double pricePrDay, double bestDiscount) {
    this.brand = brand;
    this.model = model;
    this.pricePrDay = pricePrDay;
    this.bestDiscount = bestDiscount;
  }
  //---------------Constructor.
}
