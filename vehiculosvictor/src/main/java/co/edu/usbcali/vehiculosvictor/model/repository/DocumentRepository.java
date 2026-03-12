package co.edu.usbcali.vehiculosvictor.model.repository;


import co.edu.usbcali.vehiculosvictor.model.Document;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepositoryImplementation<Document, Integer> {

}
