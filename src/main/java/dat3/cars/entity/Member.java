package dat3.cars.entity;

import dat3.security.entity.UserWithRoles;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


//-----------------Lombok
@Getter //-- Auto generer. programmet ved de er der.
@Setter //-- Auto generer. programmet ved de er der.
@ToString //(Default to String)
@EqualsAndHashCode //(default to HAS-Code)Men skal ikke bruge denne Annotation hvis man vil performance optimerer
@AllArgsConstructor //En Constructor der tager all augmenter.
@NoArgsConstructor //En Constructor uden augmenter.
//@SuperBuilder kan ikke bruges i nu.
//-----------------Lombok

@Entity //Klasse Annotation (Model)
public class Member extends UserWithRoles {

  // Id is username from UserWithRoles
  //Make sure you understand why we CANNOT make any of the fields private using the inheritance strategy we are

  //---------------Fields / attributter
  @Column(length = 30) //I Wish could be made NOT NULL
  private String firstName;
  @Column(length = 50)
  private String lastName; //I Wish could be made NOT NULL
  @Column(length = 50)  //I Wish could be made NOT NULL
  private String street;
  @Column(length = 50) //I Wish could be made NOT NULL
  private String city;
  @Column(length = 50) //I Wish could be made NOT NULL
  private String zip;

  private boolean approved;
  private int ranking;
  //---------------Fields / attributter

  //------------------------------Reservation class
  @OneToMany(mappedBy = "member")
  private List<Reservation> reservations = new ArrayList<>(); //Reservations class
  public void addReservation(Reservation res){
    reservations.add(res);
    //res.setMember(this); der er ikke brug for denne
  }
  //-----------------------------Reservation class

  //Super er nedarv. De første 3 (user, password, email) tager Super sig af.
  //---------------Constructor.
  public Member(String user, String password, String email, String firstName, String lastName, String street, String city, String zip) {
    super(user, password, email);
    this.firstName = firstName;
    this.lastName = lastName;
    this.street = street;
    this.city = city;
    this.zip = zip;
  }
  //---------------Constructor.
}
