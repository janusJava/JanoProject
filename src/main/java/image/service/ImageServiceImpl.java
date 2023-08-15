package image.service;

import baza.model.ImageReceipt;
import exception.CouldNotFindEntityException;
import image.repository.ImageReceiptRepository;
import image.utils.ImageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageReceiptRepository imageReceiptRepository;

    @Autowired
    public ImageServiceImpl(ImageReceiptRepository imageReceiptRepository) {
        this.imageReceiptRepository = imageReceiptRepository;
    }

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        ImageReceipt imageData = imageReceiptRepository.save(ImageReceipt.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes()))
                .build());
        log.info("File uploaded successfully : " + file.getOriginalFilename());
        return imageData.toString();
    }

    @Override
    public byte[] downloadImage(String fileName) {
        ImageReceipt imageReceipt = findByName(fileName);
        byte[] images = ImageUtils.decompressImage(imageReceipt.getImageData());
        return images;
    }

    @Override
    public ImageReceipt findByName(String filename) {
        Optional<ImageReceipt> imageReceipt = imageReceiptRepository.findByName(filename);
        if (imageReceipt.isPresent()) {
            return imageReceipt.get();
        } else {
            throw new CouldNotFindEntityException("Could not find ImageReceipt entity with provided filename: " + filename);
        }
    }

}
