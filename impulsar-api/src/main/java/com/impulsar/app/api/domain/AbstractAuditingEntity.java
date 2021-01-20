package com.impulsar.app.api.domain;

import java.time.Instant;

public abstract class AbstractAuditingEntity {
    private String createdBy;
    private Instant createdDate = Instant.now();
    private String lastModifiedBy;
    private Instant lastModifiedDate = Instant.now();
}
