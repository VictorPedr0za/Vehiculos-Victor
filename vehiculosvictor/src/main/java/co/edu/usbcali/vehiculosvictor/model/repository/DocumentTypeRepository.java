package co.edu.usbcali.vehiculosvictor.model.repository;

import co.edu.usbcali.vehiculosvictor.model.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {

}
