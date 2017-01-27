package com.infobase.service;

import com.infobase.domain.AuditMessage;
import com.infobase.repository.AuditMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Service class for audit messages
 */
@Service
public class AuditMessageService implements AuditMessageFacade {

    @Autowired
    private AuditMessageRepository auditMessageRepository;

    @Override
    public AuditMessage insert(AuditMessage auditMessage) {
        if(auditMessageRepository.findByMessage(auditMessage.getMessage()) == null){
            auditMessage.setCreated(new Date());
            return auditMessageRepository.save(auditMessage);
        }
        return auditMessage;
    }

    @Override
    public void updateConfimedStatus(Long id, boolean isConfirmed) {
        if(auditMessageRepository.exists(id)){
            AuditMessage auditMessage = getAuditMessageById(id);

            if(auditMessage.isConfirmed() != isConfirmed){
                auditMessage.setConfirmed(isConfirmed);
                auditMessageRepository.save(auditMessage);
            }
        }
    }

    @Override
    public void delete(Long id) {
        AuditMessage auditMessage = auditMessageRepository.findOne(id);
        if(auditMessage != null && auditMessage.getId() != null){
            auditMessageRepository.delete(auditMessage);
        }
    }

    @Override
    public AuditMessage getAuditMessageById(Long id) {
        return auditMessageRepository.findOne(id);
    }

    @Override
    public Iterable<AuditMessage> getAuditMessageList() {
        return auditMessageRepository.findAll();
    }
}
