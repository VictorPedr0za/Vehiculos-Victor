package co.edu.usbcali.vehiculosvictor.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;


@Getter
@AllArgsConstructor
public class CreateVehicleRequest {

    private String Id;
    private String brand;
    private String vehicleType;


}
