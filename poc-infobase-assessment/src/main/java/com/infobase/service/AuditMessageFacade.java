package com.infobase.service;

import com.infobase.domain.AuditMessage;

/**
 * AuditMessageFacade contract
 */
public interface AuditMessageFacade {

    /**
     * Creates a new {@link AuditMessage} object
     * @param auditMessage
     * @return AuditMessage
     */
    AuditMessage insert(AuditMessage auditMessage);

    /**
     * Change the status of a specific message
     * @param isConfirmed
     */
    void updateConfimedStatus(Long id, boolean isConfirmed);

    /**
     * Delete a {@link AuditMessage} object
     * @param id
     */
    void delete(Long id);

    /**
     * Returns a {@link AuditMessage} by Id
     * @param id
     * @return AuditMessage
     */
    AuditMessage getAuditMessageById(Long id);

    /**
     * Returns all {@link AuditMessage} objects from database
     * @return Iterable
     */
    Iterable<AuditMessage> getAuditMessageList();
}
