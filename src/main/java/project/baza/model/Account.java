package project.baza.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import project.baza.model.enums.AccountRole;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long accountId;

    @Column(nullable = false)
    AccountRole roleType;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String email;

    @OneToMany(mappedBy = "account")
    List<Receipt> receiptList;


}
