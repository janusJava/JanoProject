package project.image.service;

import org.springframework.web.multipart.MultipartFile;
import project.baza.model.ImageReceipt;

public interface ImageService {

    String uploadImage(MultipartFile file) throws Exception;

    byte[] downloadImage(String fileName);

    ImageReceipt findByName(String filename);

}
