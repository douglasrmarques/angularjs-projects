package com.infobase.repository;

import com.infobase.domain.AdPartner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for AdPartner Entity
 */
@Repository
public interface AdPartnerRepository extends CrudRepository<AdPartner, Long> {

    /**
     * Retrieves the partner by partner name
     * @param partnerName
     * @return AdPartner
     */
    AdPartner findByPartnerName(String partnerName);

    /**
     * Finds an entity by URL
     * @param url
     * @return
     */
    AdPartner findByUrl(String url);

}
