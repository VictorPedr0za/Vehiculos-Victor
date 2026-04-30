package co.edu.usbcali.vehiculosvictor.service;

import co.edu.usbcali.vehiculosvictor.dto.request.CreateDocumentRequest;
import co.edu.usbcali.vehiculosvictor.dto.request.CreateVehicleRequest;
import co.edu.usbcali.vehiculosvictor.dto.request.UpdateDocumentRequest;
import co.edu.usbcali.vehiculosvictor.dto.response.CreateDocumentResponse;
import co.edu.usbcali.vehiculosvictor.dto.response.GetVehicleResponse;
import co.edu.usbcali.vehiculosvictor.model.Document;

import java.util.List;

public interface DocumentService {

    CreateDocumentResponse createDocument(CreateDocumentRequest createDocumentRequest) throws Exception;

    List<Document> getAllDocuments();

    Document getDocumentById(Integer id);

    CreateDocumentResponse updateDocument(Integer id, UpdateDocumentRequest updateDocumentRequest) throws Exception;

}
