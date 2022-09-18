package dat3.cars.dto;

import dat3.cars.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
Data Transfer Object
An object that carries data between processes in order to reduce the number of method calls.
*/
//---------------Lombok.
@Getter //-- Auto generer. programmet ved de er der.
@Setter //-- Auto generer. programmet ved de er der.
@NoArgsConstructor //-- En Constructor uden augmenter.
//@JsonInclude(JsonInclude.Include.NON_NULL)
//---------------Lombok

public class MemberRequest {
  //---------------Fields / attributter.
  String username;
  String email;
  String password;
  String firstName;
  String lastName;
  String street;
  String city;
  String zip;
  //---------------Fields / attributter

  //---------------Constructor.
  public static Member getMemberEntity(MemberRequest m){
    return new Member(m.username,m.getPassword(),m.getEmail(), m.firstName, m.lastName,m.getStreet(), m.getCity(), m.getZip());
  }

  // Member to MemberRequest conversion
  public MemberRequest(Member m){
    this.username = m.getUsername();
    this.password = m.getPassword();
    this.email = m.getEmail();
    this.street = m.getStreet();
    this.city = m.getCity();
    this.zip = m.getZip();
  }
  //---------------Constructor.
}
