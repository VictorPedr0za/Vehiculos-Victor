package co.edu.usbcali.vehiculosvictor.service.impl;

import co.edu.usbcali.vehiculosvictor.dto.request.CreateDocumentRequest;
import co.edu.usbcali.vehiculosvictor.dto.request.UpdateDocumentRequest;
import co.edu.usbcali.vehiculosvictor.dto.response.CreateDocumentResponse;
import co.edu.usbcali.vehiculosvictor.mapper.DocumentMapper;
import co.edu.usbcali.vehiculosvictor.model.Document;
import co.edu.usbcali.vehiculosvictor.repository.DocumentRepository;
import co.edu.usbcali.vehiculosvictor.repository.VehicleRepository;
import co.edu.usbcali.vehiculosvictor.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    public CreateDocumentResponse createDocument(CreateDocumentRequest createDocumentRequest) throws Exception {
        try {
            if (Objects.isNull(createDocumentRequest.getVehicle())) {
                throw new Exception("El objeto Vehicle no puede ser nulo.");
            }
            if (Objects.isNull(createDocumentRequest.getDocumentType())) {
                throw new Exception("El objeto documentType no puede ser nulo.");
            }
            if (Objects.isNull(createDocumentRequest.getExpirationDate())) {
                throw new Exception("La fecha de expiración no puede ser nula.");
            }
            if (Objects.isNull(createDocumentRequest.getCreatedAt())) {
                throw new Exception("La fecha de creación no puede ser nula.");
            }

            Document document = Document.builder()
                    .documentType(createDocumentRequest.getDocumentType())
                    .expirationDate(createDocumentRequest.getExpirationDate())
                    .createdAt(createDocumentRequest.getCreatedAt())
                    .vehicle(createDocumentRequest.getVehicle())
                    .build();

            document = documentRepository.save(document);

            return DocumentMapper.entityToCreateDocumentResponse(document);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document getDocumentById(Integer id) {
        return documentRepository.getReferenceById(id);
    }

    @Override
    public CreateDocumentResponse updateDocument(Integer id, UpdateDocumentRequest updateDocumentRequest) throws Exception {
        try {
            // Validar request
            if (updateDocumentRequest == null) {
                throw new Exception("UpdateDocumentRequest no puede ser nulo");
            }
            if (Objects.isNull(updateDocumentRequest.getVehicle())) {
                throw new Exception("El objeto Vehicle no puede ser nulo.");
            }
            if (Objects.isNull(updateDocumentRequest.getDocumentType())) {
                throw new Exception("El objeto DocumentType no puede ser nulo.");
            }
            if (Objects.isNull(updateDocumentRequest.getExpirationDate())) {
                throw new Exception("La fecha de expiración no puede ser nula.");
            }
            if (Objects.isNull(updateDocumentRequest.getCreatedAt())) {
                throw new Exception("La fecha de creación no puede ser nula.");
            }

            // Verificar que el documento existe
            if (!documentRepository.existsById(id)) {
                throw new Exception("No existe un documento con el id: " + id);
            }

            // Traer la entidad existente de la BD
            Document document = documentRepository.getReferenceById(id);

            // Actualizar los campos
            document.setVehicle(updateDocumentRequest.getVehicle());
            document.setDocumentType(updateDocumentRequest.getDocumentType());
            document.setExpirationDate(updateDocumentRequest.getExpirationDate());
            document.setCreatedAt(updateDocumentRequest.getCreatedAt());

            // Guardar los cambios
            document = documentRepository.save(document);

            return DocumentMapper.entityToCreateDocumentResponse(document);
        } catch (Exception e) {
            throw e;
        }
    }

}