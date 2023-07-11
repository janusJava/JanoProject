package dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import mapper.BaseMapper;
import model.Product;
import model.Receipt;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateReceiptRequestDto extends BaseMapper {

    Long receiptId;

    LocalDate date;

    String shopInfo;

    List<Product> productList;

    /**
     * Mapowanie obiektu zawierajacego elementy paragonu na paragon.
     */
    public static Receipt map(CreateReceiptRequestDto createReceiptRequestDto) {
        return map(createReceiptRequestDto, Receipt.class);
    }
}
