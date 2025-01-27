package com.vitalite.vitalite.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.entities.Profile;


/**
 * Spring Data  repository for the TailleBalle entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Page<Profile>findAllByDeletedFalse(Pageable pageable);

}
