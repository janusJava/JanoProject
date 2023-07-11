package dto.response;

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
public class ReceiptResponseDto extends BaseMapper {

    Long receiptId;

    LocalDate date;

    String shopInfo;

    List<Product> productList;

    public static ReceiptResponseDto map(Receipt receipt) {
        return map(receipt, ReceiptResponseDto.class);
    }
}
