package project.image.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.baza.model.ImageReceipt;

import java.util.Optional;

public interface ImageReceiptRepository extends JpaRepository<ImageReceipt, Long> {

    Optional<ImageReceipt> findByName(String fileName);

}
