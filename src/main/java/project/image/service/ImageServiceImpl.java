package project.image.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.baza.model.ImageReceipt;
import project.exception.CouldNotFindEntityException;
import project.image.repository.ImageReceiptRepository;
import project.image.utils.ImageUtils;

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
