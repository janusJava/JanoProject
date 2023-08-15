package project.image.tesseract;

public interface TessService {

    String sendRequestToObtainTextFromImage(byte[] byteArray) throws Exception;
}
