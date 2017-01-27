package com.infobase.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * auditmessage Entity
 */
@Entity
public class AuditMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(nullable = false, updatable = true)
    private boolean isConfirmed;

    @Column(nullable = true, updatable = false)
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
