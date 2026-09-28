package com.digitalcertificate.dto;

import jakarta.validation.constraints.NotNull;

public class IssueCertificateRequest {

    @NotNull
    private Long participantId;

    @NotNull
    private Long courseId;

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}