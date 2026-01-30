package com.aramizo.qrcode_generator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aramizo.qrcode_generator.dto.QrcodeRequest;
import com.aramizo.qrcode_generator.service.QrcodeService;

@RestController
@RequestMapping
public class QrcodeController {

    private final QrcodeService qrcodeService;

    public QrcodeController(QrcodeService qrcodeService) {
        this.qrcodeService = qrcodeService;
    }

    @GetMapping("/generate")
    public ResponseEntity<String> generateQrcode(QrcodeRequest qrcodeRequest) {
        try{ 
            return ResponseEntity.ok(
                qrcodeService.generate(qrcodeRequest.content()).base64()
            );
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
