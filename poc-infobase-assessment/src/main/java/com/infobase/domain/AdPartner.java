package com.infobase.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * AdPartner domain in order to represent an AdPartner object
 */
@Entity
public class AdPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * Partner URL
     */
    @Column(nullable = false, unique = true)
    private String url;

    /**
     * Partner name
     */
    private String partnerName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return (int) ((id * id.hashCode()) + (id * 15));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(!AdPartner.class.isAssignableFrom(obj.getClass())){
            return false;
        }

        final AdPartner other = (AdPartner) obj;
        if ((this.url == null) ? (other.url != null) : !this.url.equals(other.url)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Partner, ID:" + this.id + ", URL:" + this.getUrl() + ", Partner Name:" + this.getPartnerName();
    }
}
