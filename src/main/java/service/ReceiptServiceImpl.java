package service;

import dto.request.CreateReceiptRequestDto;
import dto.response.ReceiptResponseDto;
import model.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReceiptRepository;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    @Autowired
    private ReceiptServiceImpl(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @Override
    public List<Receipt> findAllUserReceipts(Long userId) {
        return receiptRepository.findAllByAccountId(userId);
    }

    @Override
    public ReceiptResponseDto createNewReceipt(CreateReceiptRequestDto createReceiptRequestDto) {
        Receipt receipt = Receipt.builder()
                .date(createReceiptRequestDto.getDate())
                .productList(createReceiptRequestDto.getProductList())
                .shopInfo(createReceiptRequestDto.getShopInfo())
                .build();
        receiptRepository.save(receipt);
        return ReceiptResponseDto.map(receipt);
    }
}
