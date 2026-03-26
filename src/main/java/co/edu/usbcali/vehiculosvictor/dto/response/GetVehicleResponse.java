package co.edu.usbcali.vehiculosvictor.dto.response;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetVehicleResponse {

   //Esta clase es inmutable
    private Integer id;
    private String brand;
    private String vehicleType;

}
