package project.baza.service;

import project.baza.model.Receipt;

import java.util.List;

public interface ReceiptService {

    List<Receipt> findAllUserReceipts(Long userId);

}
