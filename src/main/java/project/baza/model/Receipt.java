package project.baza.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long receiptId;

    @Column(nullable = false)
    LocalDate date;

    @Column(nullable = false)
    String shopName;

    @Column(nullable = false)
    BigDecimal money;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @OneToOne
    @JoinColumn(name = "imageReceipt_id")
    ImageReceipt imageReceipt;

    @OneToMany(mappedBy = "receipt")
    List<Product> productList;

}
