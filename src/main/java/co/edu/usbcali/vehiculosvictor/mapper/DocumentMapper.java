package co.edu.usbcali.vehiculosvictor.mapper;


import co.edu.usbcali.vehiculosvictor.dto.request.CreateDocumentRequest;
import co.edu.usbcali.vehiculosvictor.dto.response.CreateDocumentResponse;
import co.edu.usbcali.vehiculosvictor.model.Document;
import lombok.Getter;

@Getter
public class DocumentMapper {


    public static CreateDocumentResponse entityToCreateDocumentResponse(Document document){
        return CreateDocumentResponse.builder()
                .id(document.getId())
                .vehicle(document.getVehicle())
                .documentType(document.getDocumentType())
                .expirationDate(document.getExpirationDate())
                .createdAt(document.getCreatedAt())
                .build();
    }
}
