package dat3.cars.service;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repository.CarRepository;
import dat3.cars.repository.MemberRepository;
import dat3.cars.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

//Ingen dto her.
@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    MemberRepository memberRepository;
    CarRepository carRepository;

    public ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
    }


    //Lambda ()-> expectation en function uden augmenter
    public void reserveCar(String udername, int carId, LocalDate date){
        Member member = memberRepository.findById(udername).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
        Car car = carRepository.findById(carId).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
        if(reservationRepository.existsByCar_IdAndRentalDate(carId, date)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car reservd this date"); //This is an uncheck Exception.
        }

        Reservation reservation = new Reservation(member, car, date);
        reservationRepository.save(reservation);
    }
}
