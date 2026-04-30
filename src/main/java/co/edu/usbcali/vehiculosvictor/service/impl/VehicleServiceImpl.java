package co.edu.usbcali.vehiculosvictor.service.impl;

import co.edu.usbcali.vehiculosvictor.dto.request.CreateVehicleRequest;
import co.edu.usbcali.vehiculosvictor.dto.request.UpdateVehicleRequest;
import co.edu.usbcali.vehiculosvictor.dto.response.GetVehicleResponse;
import co.edu.usbcali.vehiculosvictor.mapper.VehicleMapper;
import co.edu.usbcali.vehiculosvictor.model.Vehicle;
import co.edu.usbcali.vehiculosvictor.repository.VehicleRepository;
import co.edu.usbcali.vehiculosvictor.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public GetVehicleResponse createVehicle(CreateVehicleRequest createVehicleRequest) throws Exception {
        try {
            if (createVehicleRequest == null) {
                throw new Exception("CreateVehicleRequest no puede ser nulo");
            }
            if (createVehicleRequest.getBrand() == null || createVehicleRequest.getBrand().isBlank()) {
                throw new Exception("La marca es requerida");
            }
            if (createVehicleRequest.getVehicleType() == null || createVehicleRequest.getVehicleType().isBlank()) {
                throw new Exception("El tipo de vehículo es requerido");
            }

            Vehicle vehicle = VehicleMapper.createVehicleRequestToEntity(createVehicleRequest);
            vehicle = vehicleRepository.save(vehicle);

            return VehicleMapper.entityToGetVehicleResponse(vehicle);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<GetVehicleResponse> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return VehicleMapper.entityToListGetVehicleResponse(vehicles);
    }

    @Override
    public GetVehicleResponse getVehicleById(Integer id) {
        Vehicle vehicle = vehicleRepository.getReferenceById(id);
        return VehicleMapper.entityToGetVehicleResponse(vehicle);
    }

    @Override
    public GetVehicleResponse updateVehicle(Integer id, UpdateVehicleRequest updateVehicleRequest) throws Exception {
        try {
            if (Objects.isNull(id) || id <= 0) {
                throw new Exception("id no puede ser nulo tampoco un número menor o igual a cero (0)");
            }
            // Validar request
            if (updateVehicleRequest == null) {
                throw new Exception("UpdateVehicleRequest no puede ser nulo");
            }
            if (updateVehicleRequest.getBrand() == null || updateVehicleRequest.getBrand().isBlank()) {
                throw new Exception("La marca es requerida");
            }
            if (updateVehicleRequest.getVehicleType() == null || updateVehicleRequest.getVehicleType().isBlank()) {
                throw new Exception("El tipo de vehículo es requerido");
            }

            // Traer el vehículo desde la BD
            Vehicle vehicle = vehicleRepository.findById(id)
                    .orElseThrow(() -> new Exception("No existe un vehículo con el id: "+ id));

            // Actualizar los campos
            vehicle.setBrand(updateVehicleRequest.getBrand());
            vehicle.setVehicleType(updateVehicleRequest.getVehicleType());

            // Guardar los cambios
            vehicle = vehicleRepository.save(vehicle);

            return VehicleMapper.entityToGetVehicleResponse(vehicle);
        } catch (Exception e) {
            throw e;
        }
    }

}