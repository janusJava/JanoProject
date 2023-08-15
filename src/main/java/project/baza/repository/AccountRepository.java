package project.baza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.baza.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
