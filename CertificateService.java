package com.digitalcertificate.service;

import com.digitalcertificate.exception.CertificateNotFoundException;
import com.digitalcertificate.exception.CertificateRevokedException;
import com.digitalcertificate.model.Certificate;
import com.digitalcertificate.model.Course;
import com.digitalcertificate.model.Participant;
import com.digitalcertificate.repository.CertificateRepository;
import com.digitalcertificate.repository.CourseRepository;
import com.digitalcertificate.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;
    public Certificate verifyCertificate(String verificationCode) {

        Certificate certificate =
                certificateRepository
                        .findByVerificationCode(verificationCode)
                        .orElseThrow(() ->
                                new CertificateNotFoundException(
                                        "Certificate not found"));

        if (certificate.isRevoked()) {
            throw new CertificateRevokedException(
                    "Certificate has been revoked");
        }

        return certificate;
    }
    public Certificate revokeCertificate(String certificateId) {

        Certificate certificate =
                certificateRepository
                        .findById(certificateId)
                        .orElseThrow(() ->
                                new CertificateNotFoundException(
                                        "Certificate not found"));

        certificate.setRevoked(true);

        return certificateRepository.save(certificate);
    }
    public String generateVerificationCode() {

        String code;

        do {
            code = UUID.randomUUID()
                    .toString()
                    .substring(0, 8)
                    .toUpperCase();

        } while (
                certificateRepository
                        .existsByVerificationCode(code));

        return code;
    }
    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private CourseRepository courseRepository;
    private String generateCertificateId() {

        return "CERT" + System.currentTimeMillis();
    }
    public Certificate issueCertificate(
            Long participantId,
            Long courseId) {

        Participant participant =
                participantRepository.findById(participantId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Participant not found"));

        Course course =
                courseRepository.findById(courseId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Course not found"));

        Certificate certificate =
                new Certificate();

        certificate.setCertificateId(
                generateCertificateId());

        certificate.setVerificationCode(
                generateVerificationCode());

        certificate.setIssueDate(
                java.time.LocalDate.now());

        certificate.setRevoked(false);

        certificate.setParticipant(participant);

        certificate.setCourse(course);

        return certificateRepository.save(certificate);
    }
}