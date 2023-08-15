package project.image.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.baza.model.ImageReceipt;
import project.exception.CouldNotFindEntityException;
import project.image.repository.ImageReceiptRepository;
import project.image.tesseract.TessService;
import project.image.utils.ImageUtils;

import java.util.Optional;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageReceiptRepository imageReceiptRepository;

    private final TessService tessService;

    @Autowired
    public ImageServiceImpl(ImageReceiptRepository imageReceiptRepository, TessService tessService) {
        this.imageReceiptRepository = imageReceiptRepository;
        this.tessService = tessService;
    }

    @Override
    public String uploadImage(MultipartFile file) throws Exception {
        ImageReceipt imageData = ImageReceipt.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes()))
                .build();
        imageReceiptRepository.save(imageData);
        log.info("File uploaded successfully : " + file.getOriginalFilename());
        String response = tessService.sendRequestToObtainTextFromImage(file.getBytes());
        return response;
    }

    @Override
    public byte[] downloadImage(String fileName) {
        ImageReceipt imageReceipt = findByName(fileName);
        return ImageUtils.decompressImage(imageReceipt.getImageData());
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
