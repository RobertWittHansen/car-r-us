package dat3.cars.repository;

import dat3.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


//Hele min CRUD ligger i JpaRepository
//JPA lave quire i databasen, den omdanner key words til SQL syntaks.
public interface CarRepository extends JpaRepository<Car,Integer> {

  List<Car> findCarByBrand(String brand);
  //Select * from Car where Brand = 'Brand'
  List<Car> findCarByPricePrDayBetween(double start, double min);


}
