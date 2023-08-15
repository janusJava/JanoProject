package project.image.service;

import org.springframework.web.multipart.MultipartFile;
import project.baza.model.ImageReceipt;

import java.io.IOException;

public interface ImageService {

    String uploadImage(MultipartFile file) throws IOException;

    byte[] downloadImage(String fileName);

    ImageReceipt findByName(String filename);

}
