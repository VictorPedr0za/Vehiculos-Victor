package co.edu.usbcali.vehiculosvictor.controller;

import co.edu.usbcali.vehiculosvictor.dto.request.CreateVehicleRequest;
import co.edu.usbcali.vehiculosvictor.dto.request.UpdateVehicleRequest;
import co.edu.usbcali.vehiculosvictor.dto.response.GetVehicleResponse;
import co.edu.usbcali.vehiculosvictor.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/all")
    public List<GetVehicleResponse> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetVehicleResponse> getVehicleById(@PathVariable Integer id) {
        GetVehicleResponse vehicleResponse = vehicleService.getVehicleById(id);
        return new ResponseEntity<>(vehicleResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<GetVehicleResponse> createVehicle(
            @RequestBody CreateVehicleRequest createVehicleRequest) throws Exception {
        GetVehicleResponse vehicleCreated = vehicleService.createVehicle(createVehicleRequest);
        return new ResponseEntity<>(vehicleCreated, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<GetVehicleResponse> updateVehicle(
            @PathVariable Integer id,
            @RequestBody UpdateVehicleRequest updateVehicleRequest) throws Exception {
        GetVehicleResponse vehicleUpdated = vehicleService.updateVehicle(id, updateVehicleRequest);
        return new ResponseEntity<>(vehicleUpdated, HttpStatus.OK);
    }
}