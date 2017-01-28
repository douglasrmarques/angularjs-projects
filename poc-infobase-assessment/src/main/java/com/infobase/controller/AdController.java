package com.infobase.controller;

import com.infobase.domain.AdPartner;
import com.infobase.service.AdServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for marketing services
 */
@RestController
@RequestMapping(value = "/ad")
public class AdController {

    @Autowired
    AdServiceFacade adServiceFacade;

    @RequestMapping(value = "/getAdDefaultPartner", method = RequestMethod.GET)
    public AdPartner getAdDefaultPartner(){
        return adServiceFacade.getAdDefaultPartner();
    }

    @RequestMapping(value = "/getAdPartner", method = RequestMethod.GET)
    public AdPartner getAdPartner(@RequestBody String partnerName){
        return adServiceFacade.getAdPartnerByName(partnerName);
    }

    @RequestMapping(value = "/insertAdPartner", method = RequestMethod.POST)
    public AdPartner insertAdPartner(@RequestBody AdPartner adPartner){
        return adServiceFacade.insertAdPartner(adPartner);
    }

    @RequestMapping(value = "/updateAdPartner", method = RequestMethod.POST)
    public AdPartner updateAdPartner(@RequestBody AdPartner adPartner){
        return adServiceFacade.updateAdPartner(adPartner);
    }

}
