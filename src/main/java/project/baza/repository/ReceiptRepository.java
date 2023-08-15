package project.baza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.baza.model.Receipt;

import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    List<Receipt> findAllByAccount_AccountId(Long userId);
}
