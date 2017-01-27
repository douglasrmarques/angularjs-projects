package com.infobase.service;

import com.infobase.domain.AdPartner;

/**
 * AdServiceFacade contract
 */
public interface AdServiceFacade {

    /**
     * Finds a partner entity by id
     * @param id
     * @return AdPartner
     */
    AdPartner getAdPartnerById(Long id);

    /**
     * Return a partner by URL
     * @param url
     * @return AdPartner
     */
    AdPartner getAdPartnerByURL(String url);

    /**
     * Should return the default URL defined for the advertisement
     * @return AdPartner
     */
    AdPartner getAdDefaultPartner();

    /**
     * Retrieves a partner by name
     * @param partnerName
     * @return AdPartner
     */
    AdPartner getAdPartnerByName(String partnerName);

    /**
     * Insert a new partner into database
     * @param adPartner
     * @return AdPartner
     */
    AdPartner insertAdPartner(AdPartner adPartner);

    /**
     * Update the partner into databse
     * @param adPartner
     * @return AdPartner
     */
    AdPartner updateAdPartner(AdPartner adPartner);
}
