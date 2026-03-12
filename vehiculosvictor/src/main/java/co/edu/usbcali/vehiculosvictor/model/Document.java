package co.edu.usbcali.vehiculosvictor.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "documents")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false, referencedColumnName = "id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "document_type_id",  nullable = false, referencedColumnName = "id")
    private DocumentType documentType;

    @Column(name= "expiration_date",  nullable = false)
    private Date expirationDate;

    @Column(name= "created_at",  nullable = false)
    private Timestamp createdAt;


}
