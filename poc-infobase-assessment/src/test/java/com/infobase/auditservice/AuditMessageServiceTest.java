package com.infobase.auditservice;

import com.infobase.domain.AuditMessage;
import com.infobase.service.AuditMessageFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;

/**
 * Unit test for auditmessage Service implementation
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class AuditMessageServiceTest {

    @Autowired
    private AuditMessageFacade auditMessageFacade;

    private AuditMessage auditMessage;

    @Before
    public void setUp(){
        auditMessage = new AuditMessage();
        auditMessage.setConfirmed(false);
        auditMessage.setCreated(new Date());
        auditMessage.setMessage("Audit Message Test");
        auditMessage.setUserName("Undefined");
    }

    @Test
    public void insertionTest(){
        Assert.assertNull(auditMessage.getId());
        auditMessage = auditMessageFacade.insert(auditMessage);
        Assert.assertNotNull(auditMessage.getId());
    }

    @Test
    public void updateMessageConfirmationTest(){
        Assert.assertNull(auditMessage.getId());
        auditMessage = auditMessageFacade.insert(auditMessage);

        Assert.assertNotNull(auditMessage.getId());
        Assert.assertEquals(false, auditMessage.isConfirmed());

        auditMessage.setConfirmed(true);
        auditMessageFacade.updateConfimedStatus(auditMessage.getId(), true);

        auditMessage = auditMessageFacade.getAuditMessageById(auditMessage.getId());

        Assert.assertNotNull(auditMessage);
        Assert.assertNotNull(auditMessage.getId());
        Assert.assertEquals(true, auditMessage.isConfirmed());
    }

    @Test
    public void deleteTest(){
        Assert.assertNull(auditMessage.getId());
        auditMessage = auditMessageFacade.insert(auditMessage);
        Assert.assertNotNull(auditMessage.getId());

        auditMessageFacade.delete(auditMessage.getId());

        auditMessage = auditMessageFacade.getAuditMessageById(auditMessage.getId());
        Assert.assertNull(auditMessage);
    }

    @Test
    public void insertMultipleMessagesAndRetrieveTest(){
        AuditMessage auditMessage1 = new AuditMessage();
        auditMessage1.setConfirmed(false);
        auditMessage1.setUserName("Undefined");
        auditMessage1.setMessage("Message test multiple insertion 1");
        auditMessage1.setCreated(new Date());

        auditMessage1 = auditMessageFacade.insert(auditMessage1);
        Assert.assertNotNull(auditMessage1.getId());

        AuditMessage auditMessage2 = new AuditMessage();
        auditMessage2.setConfirmed(false);
        auditMessage2.setUserName("Undefined");
        auditMessage2.setMessage("Message test multiple insertion 2");
        auditMessage2.setCreated(new Date());

        auditMessage2 = auditMessageFacade.insert(auditMessage2);
        Assert.assertNotNull(auditMessage2.getId());

        AuditMessage auditMessage3 = new AuditMessage();
        auditMessage3.setConfirmed(false);
        auditMessage3.setUserName("Undefined");
        auditMessage3.setMessage("Message test multiple insertion 3");
        auditMessage3.setCreated(new Date());

        auditMessage3 = auditMessageFacade.insert(auditMessage3);
        Assert.assertNotNull(auditMessage3.getId());

        AuditMessage auditMessage4 = new AuditMessage();
        auditMessage4.setConfirmed(false);
        auditMessage4.setUserName("Undefined");
        auditMessage4.setMessage("Message test multiple insertion 4");
        auditMessage4.setCreated(new Date());

        auditMessage4 = auditMessageFacade.insert(auditMessage4);
        Assert.assertNotNull(auditMessage4.getId());

        Iterable<AuditMessage> auditMessages = auditMessageFacade.getAuditMessageList();

        int count = 0;
        Iterator<AuditMessage> iterator = auditMessages.iterator();

        while(iterator.hasNext()){
            iterator.next();
            count++;
        }

        Assert.assertEquals(4, count);

        auditMessageFacade.delete(auditMessage2.getId());
        auditMessages = auditMessageFacade.getAuditMessageList();

        count = 0;
        iterator = auditMessages.iterator();

        while(iterator.hasNext()){
            iterator.next();
            count++;
        }

        Assert.assertEquals(3, count);
    }
}
