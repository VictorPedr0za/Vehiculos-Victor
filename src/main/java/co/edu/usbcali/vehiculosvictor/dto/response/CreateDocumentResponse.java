package co.edu.usbcali.vehiculosvictor.dto.response;


import co.edu.usbcali.vehiculosvictor.model.DocumentType;
import co.edu.usbcali.vehiculosvictor.model.Vehicle;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Builder
public class CreateDocumentResponse {


    private Integer id;
    private Vehicle vehicle;
    private DocumentType documentType;
    private Date expirationDate;
    private Timestamp createdAt;



}
