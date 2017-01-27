package com.infobase.repository;

import com.infobase.domain.AuditMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for auditmessage services
 */
@Repository
public interface AuditMessageRepository extends CrudRepository<AuditMessage, Long> {

    /**
     * Returns a {@link AuditMessage} by message
     * @param message
     * @return AuditMessage
     */
    AuditMessage findByMessage(String message);

}
