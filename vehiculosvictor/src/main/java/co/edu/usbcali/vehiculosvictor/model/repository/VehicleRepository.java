package co.edu.usbcali.vehiculosvictor.model.repository;


import co.edu.usbcali.vehiculosvictor.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
