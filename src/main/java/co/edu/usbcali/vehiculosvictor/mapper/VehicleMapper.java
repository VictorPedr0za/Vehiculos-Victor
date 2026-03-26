package co.edu.usbcali.vehiculosvictor.mapper;

import co.edu.usbcali.vehiculosvictor.dto.response.GetVehicleResponse;
import co.edu.usbcali.vehiculosvictor.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleMapper {

    public static GetVehicleResponse entityToGetVehicleResponse(Vehicle vehicle){

        //Instanciar nuevo objeto GetVehicleResponse

        GetVehicleResponse getVehicleResponse = GetVehicleResponse.builder()
                .id(vehicle.getId())
                .brand(vehicle.getBrand())
                .vehicleType(vehicle.getVehicleType())
                .build();

        return getVehicleResponse;
    }

    public static List<GetVehicleResponse> entityToListGetVehicleResponse(List<Vehicle> vehicles){

        //Instanciar lista de objetos GetVehicleResponse vacía inicialmente
     /*   List <GetVehicleResponse> getVehicleResponseList = new ArrayList<>();

        //Iterar sobre la lista de objetos Vehicle y agregarlos a la lista de objetos GetVehicleResponse
        for(int i = 0; i < vehicles.size(); i++){
            Vehicle vehicle = vehicles.get(i);
            GetVehicleResponse getVehicleResponse  = entityToGetVehicleResponse(vehicle);

            getVehicleResponseList.add(getVehicleResponse);


        }

        //Retornar la lista de DTO GetVehicleResponse
     return getVehicleResponseList;

      */
        return vehicles.stream().map(VehicleMapper::entityToGetVehicleResponse).toList();
    }

}
