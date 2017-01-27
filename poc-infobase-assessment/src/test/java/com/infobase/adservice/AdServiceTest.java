package com.infobase.adservice;

import com.infobase.domain.AdPartner;
import com.infobase.service.AdService;
import com.infobase.service.AdServiceFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Unit test for adservices
 */
@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class AdServiceTest {

    @Autowired
    AdServiceFacade adServiceFacade;

    private AdPartner adPartner;

    @Before
    public void setUp(){
        adPartner = new AdPartner();
        adPartner.setPartnerName("Partner ABC Teste 123");
        adPartner.setUrl("http://localteste.123/test.txt");
    }

    @Test
    public void testFindANonExistentAdPartnerByPartnerName(){
        AdPartner adPartner = new AdPartner();
        adPartner = adServiceFacade.getAdPartnerByName("PartnerABC");

        Assert.assertNull(adPartner.getId());
        Assert.assertNull(adPartner.getPartnerName());
        Assert.assertEquals(adServiceFacade.getAdDefaultPartner().getUrl(), adPartner.getUrl());
    }

    @Test
    public void testInsertion(){
        final String url = adPartner.getUrl();
        final String partnerName = adPartner.getPartnerName();

        adPartner = adServiceFacade.insertAdPartner(adPartner);

        Assert.assertNotNull(adPartner.getId());
        Assert.assertEquals(url, adPartner.getUrl());
        Assert.assertEquals(partnerName, adPartner.getPartnerName());
    }

    @Test
    public void testUpdateAdPartner(){
        adPartner = adServiceFacade.insertAdPartner(adPartner);

        Assert.assertNotNull(adPartner.getId());

        final String url = adPartner.getUrl();
        final String partnerName = adPartner.getPartnerName();
        final Long id = adPartner.getId();

        adPartner.setPartnerName("PartnerDEF");
        adPartner.setUrl("http://localteste.456/test.txt");
        adPartner = adServiceFacade.updateAdPartner(adPartner);

        Assert.assertNotEquals(adPartner.getUrl(), url);
        Assert.assertNotEquals(adPartner.getPartnerName(), partnerName);
        Assert.assertEquals(id, adPartner.getId());
    }

    @Test
    public void testDuplicationInURL(){
        AdPartner adPartner1 = new AdPartner();
        adPartner1.setUrl("http://localteste.456/test.txt");
        adPartner1 = adServiceFacade.insertAdPartner(adPartner1);

        Assert.assertNotNull(adPartner1.getId());

        AdPartner adPartner2 = new AdPartner();
        adPartner2.setUrl("http://localteste.456/test.txt");
        adPartner2 = adServiceFacade.insertAdPartner(adPartner2);

        Assert.assertNull(adPartner2.getId());
    }
}
