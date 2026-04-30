package co.edu.usbcali.vehiculosvictor.dto.request;

import co.edu.usbcali.vehiculosvictor.model.DocumentType;
import co.edu.usbcali.vehiculosvictor.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class UpdateDocumentRequest {

    private Vehicle vehicle;
    private DocumentType documentType;
    private Date expirationDate;
    private Timestamp createdAt;

}
