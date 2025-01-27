package com.vitalite.vitalite.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vitalite.vitalite.model.ProfileDTO;

import java.util.Optional;

/**
 * Service Interface for managing TailleBalle.
 */
public interface ProfileService {

    /**
     * Save a tailleBalle.
     *
     * @param profileDTO the entity to save
     * @return the persisted entity
     */
    ProfileDTO save(ProfileDTO profileDTO);

    /**
     * Get all the tailleBalles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ProfileDTO> findAll(Pageable pageable);


    /**
     * Get the "id" tailleBalle.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ProfileDTO> findOne(Long id);

    /**
     * Delete the "id" tailleBalle.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
