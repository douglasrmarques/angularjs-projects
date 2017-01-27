package com.infobase.service;

import com.infobase.domain.AdPartner;
import com.infobase.repository.AdPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Service class for advertisement partners
 */
@Service
@Component
public class AdService implements AdServiceFacade {

    @Autowired
    private AdPartnerRepository adPartnerRepository;

    @Value("${ad.default.url}")
    private String defaultAdURL;

    @Override
    public AdPartner getAdDefaultPartner() {
        AdPartner adPartner = new AdPartner();
        adPartner.setUrl(this.defaultAdURL);
        return adPartner;
    }

    @Override
    public AdPartner getAdPartnerByName(String partnerName) {
        AdPartner adPartner = adPartnerRepository.findByPartnerName(partnerName);

        if(adPartner == null){
            adPartner = getAdDefaultPartner();
        }

        return adPartner;
    }

    @Override
    public AdPartner insertAdPartner(AdPartner adPartner) {
        if(adPartner != null && adPartner.getUrl() != null){
            if(adPartnerRepository.findByUrl(adPartner.getUrl()) == null){
                return adPartnerRepository.save(adPartner);
            }
        }

        return adPartner;
    }

    @Override
    public AdPartner updateAdPartner(AdPartner adPartner) {
        if(adPartnerRepository.exists(adPartner.getId())){
            return adPartnerRepository.save(adPartner);
        }

        return adPartner;
    }

    @Override
    public AdPartner getAdPartnerByURL(String url) {
        return adPartnerRepository.findByUrl(url);
    }

    @Override
    public AdPartner getAdPartnerById(Long id) {
        return adPartnerRepository.findOne(id);
    }
}
