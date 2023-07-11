package service;

import dto.request.CreateReceiptRequestDto;
import dto.response.ReceiptResponseDto;
import model.Receipt;

import java.util.List;

public interface ReceiptService {

    List<Receipt> findAllUserReceipts(Long userId);

    ReceiptResponseDto createNewReceipt(CreateReceiptRequestDto createReceiptRequestDto);
    
}
