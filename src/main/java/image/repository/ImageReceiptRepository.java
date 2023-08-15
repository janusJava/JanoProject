package image.repository;

import baza.model.ImageReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageReceiptRepository extends JpaRepository<ImageReceipt, Long> {

    Optional<ImageReceipt> findByName(String fileName);

}
