package baza.service;

import baza.model.Receipt;

import java.util.List;

public interface ReceiptService {

    List<Receipt> findAllUserReceipts(Long userId);

}
