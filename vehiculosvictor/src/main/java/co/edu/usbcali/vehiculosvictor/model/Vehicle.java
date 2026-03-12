package co.edu.usbcali.vehiculosvictor.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "vehicles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Primary Key

    @Column(name = "brand", nullable = false, unique = true, length = 30)
    private String brand;

    @Column(name = "color", nullable = false, unique = true, length = 30)
    private String color;

    @Column(name = "vehicle_type", nullable = false, unique = true, length = 30)
    private String vehicleType;

    @Column(name= "fuel_type",  nullable = false, unique = true, length = 30)
    private String fuelType;

    @Column(name= "model_year",  nullable = false, unique = true, length = 30)
    private Integer modelYear;

    @Column(name= "created_at",  nullable = false, unique = true)
    private Timestamp createdAt;

    @Column(name= "registration_date",  nullable = false, unique = true)
    private Date registrationDate;





}
