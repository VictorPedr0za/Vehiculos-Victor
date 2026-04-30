package co.edu.usbcali.vehiculosvictor.controller;

import co.edu.usbcali.vehiculosvictor.dto.request.CreateDocumentRequest;
import co.edu.usbcali.vehiculosvictor.dto.request.UpdateDocumentRequest;
import co.edu.usbcali.vehiculosvictor.dto.response.CreateDocumentResponse;
import co.edu.usbcali.vehiculosvictor.model.Document;
import co.edu.usbcali.vehiculosvictor.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("/all")
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Integer id) {
        Document document = documentService.getDocumentById(id);
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateDocumentResponse> createDocument(
            @RequestBody CreateDocumentRequest createDocumentRequest) throws Exception {
        CreateDocumentResponse documentCreated = documentService.createDocument(createDocumentRequest);
        return new ResponseEntity<>(documentCreated, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CreateDocumentResponse> updateDocument(
            @PathVariable Integer id,
            @RequestBody UpdateDocumentRequest updateDocumentRequest) throws Exception {
        CreateDocumentResponse documentUpdated = documentService.updateDocument(id, updateDocumentRequest);
        return new ResponseEntity<>(
                documentUpdated,
                HttpStatus.OK);
    }

}