package co.edu.usbcali.vehiculosvictor.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateVehicleRequest {

    private String brand;
    private String vehicleType;

}