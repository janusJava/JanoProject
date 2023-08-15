package project.baza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.baza.model.Receipt;
import project.baza.repository.ReceiptRepository;

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
        return receiptRepository.findAllByAccount_AccountId(userId);
    }


}
