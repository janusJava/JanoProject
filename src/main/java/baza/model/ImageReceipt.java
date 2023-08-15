package baza.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long imageReceiptId;

    String name;
    String type;
    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;
}
