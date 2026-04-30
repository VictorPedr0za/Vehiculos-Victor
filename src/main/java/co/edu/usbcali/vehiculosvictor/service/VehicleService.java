package co.edu.usbcali.vehiculosvictor.service;

import co.edu.usbcali.vehiculosvictor.dto.request.CreateVehicleRequest;
import co.edu.usbcali.vehiculosvictor.dto.request.UpdateVehicleRequest;
import co.edu.usbcali.vehiculosvictor.dto.response.GetVehicleResponse;

import java.util.List;

public interface VehicleService {

    GetVehicleResponse createVehicle(CreateVehicleRequest createVehicleRequest) throws Exception;

    List<GetVehicleResponse> getAllVehicles();

    GetVehicleResponse getVehicleById(Integer id);

    GetVehicleResponse updateVehicle(Integer id, UpdateVehicleRequest updateVehicleRequest) throws Exception;

}