package co.edu.usbcali.vehiculosvictor.controller;


import co.edu.usbcali.vehiculosvictor.dto.response.GetVehicleResponse;
import co.edu.usbcali.vehiculosvictor.mapper.VehicleMapper;
import co.edu.usbcali.vehiculosvictor.model.Vehicle;
import co.edu.usbcali.vehiculosvictor.model.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleRepository vehicleRepository;
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/all")
    public List<GetVehicleResponse> getAllVehicles() {


        //Declarar nueva lista de VehicleResponse
        List<GetVehicleResponse> vehicleResponse;


        //Ir al repository
        List<Vehicle> vehicles = vehicleRepository.findAll();

        //Convertir la lista de peliculas a lista de vehicleReponse
        vehicleResponse = VehicleMapper.entityToListGetVehicleResponse(vehicles);

        //Retornar la lista de vehicleResponse
        return vehicleResponse;
    }

        @GetMapping( "/{id}")
        public ResponseEntity<GetVehicleResponse> getVehicleById(@PathVariable Integer id) {

            Vehicle  vehicle = vehicleRepository.getReferenceById(id);
            GetVehicleResponse vehicleResponse = VehicleMapper.entityToGetVehicleResponse(vehicle);


            return new ResponseEntity<>(
              vehicleResponse,
              HttpStatus.OK

            );

        }


    }


