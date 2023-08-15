package project.image.tesseract;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.leptonica.PIX;
import org.bytedeco.tesseract.TessBaseAPI;
import org.springframework.stereotype.Service;
import project.exception.TessException;

import static org.bytedeco.leptonica.global.leptonica.pixReadMem;

@Service
public class TessServiceImpl implements TessService {

    private static final String TESS_DATA = "C:\\Program Files\\Tesseract-OCR\\tessdata";
    private static final String LANGUAGE = "pol";

    @Override
    public String sendRequestToObtainTextFromImage(byte[] byteArray) {
        try {
            TessBaseAPI tessApi = new TessBaseAPI();
            tessApi.Init(TESS_DATA, LANGUAGE, 3);
            tessApi.SetPageSegMode(1);
            PIX image = pixReadMem(byteArray, byteArray.length);
            tessApi.SetImage(image);
            BytePointer outText = tessApi.GetUTF8Text();
            tessApi.End();
            return outText.getString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new TessException("Could not process the image.");
        }
    }


}
