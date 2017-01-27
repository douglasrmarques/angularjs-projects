package com.infobase.controller;

import com.infobase.domain.AuditMessage;
import com.infobase.service.AuditMessageFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuditMessage Controller
 */
@RestController
@RequestMapping(value = "/audit")
public class AuditMessageController {

    @Autowired
    AuditMessageFacade auditMessageFacade;

    @RequestMapping(value = "/getMessageList", method = RequestMethod.GET)
    public Iterable<AuditMessage> getAuditMessageList(){
        return auditMessageFacade.getAuditMessageList();
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public AuditMessage sendMessage(@RequestBody AuditMessage auditMessage){
        return auditMessageFacade.insert(auditMessage);
    }

    @RequestMapping(value = "/confirmMessage", method = RequestMethod.POST)
    public void confirmMessage(@RequestBody Long id){
        auditMessageFacade.updateConfimedStatus(id, true);
    }

    @RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
    public void deleteMessage(@RequestBody Long id){
        auditMessageFacade.delete(id);
    }

}
