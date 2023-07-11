package model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    String shopInfo;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.MERGE)
    List<Product> productList;

}
