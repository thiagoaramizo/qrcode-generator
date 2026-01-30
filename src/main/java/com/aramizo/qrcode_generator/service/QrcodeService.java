package com.aramizo.qrcode_generator.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.aramizo.qrcode_generator.dto.QrcodeResponse;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QrcodeService {

    public QrcodeResponse generate(String content) throws WriterException, IOException {
        
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
        byte[] pngQrcode = byteArrayOutputStream.toByteArray();
        
        String base64Qrcode = java.util.Base64.getEncoder().encodeToString(pngQrcode);

        return new QrcodeResponse("data:image/png;base64," + base64Qrcode);
    }

}
