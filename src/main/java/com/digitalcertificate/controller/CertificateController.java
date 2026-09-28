package com.digitalcertificate.controller;

import com.digitalcertificate.dto.IssueCertificateRequest;
import com.digitalcertificate.model.Certificate;
import com.digitalcertificate.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;
    @GetMapping("/verify/{code}")
    public Certificate verifyCertificate(
            @PathVariable String code) {

        return certificateService
                .verifyCertificate(code);
    }
    @PutMapping("/{id}/revoke")
    public Certificate revokeCertificate(
            @PathVariable String id) {

        return certificateService
                .revokeCertificate(id);
    }
    @PostMapping
    public Certificate issueCertificate(
            @RequestBody
            IssueCertificateRequest request) {

        return certificateService.issueCertificate(
                request.getParticipantId(),
                request.getCourseId());
    }

    public CertificateService getCertificateService() {
        return certificateService;
    }

    public void setCertificateService(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

}