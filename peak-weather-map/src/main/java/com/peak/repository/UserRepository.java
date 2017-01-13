package com.peak.repository;

import com.peak.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * It retrieves a user as its userFacebookId
     * @param userFacebookId
     * @return User
     */
    User findByUserFacebookId(String userFacebookId);

}
