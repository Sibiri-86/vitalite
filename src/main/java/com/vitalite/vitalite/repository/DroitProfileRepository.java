package com.vitalite.vitalite.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.security.DroitProfile;


/**
 * Spring Data  repository for the Agent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DroitProfileRepository extends JpaRepository<DroitProfile, Long> {
    List<DroitProfile> findByProfileIdAndDeletedFalse(Long profileId);
    Page<DroitProfile>findAllByDeletedFalse(Pageable pageable);
}
