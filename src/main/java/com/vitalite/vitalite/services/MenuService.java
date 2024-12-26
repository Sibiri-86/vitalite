package com.vitalite.vitalite.services;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vitalite.vitalite.model.MenuDTO;

import java.util.Optional;

/**
 * Service Interface for managing TailleBalle.
 */
public interface MenuService {

    /**
     * Save a tailleBalle.
     *
     * @param menuDTO the entity to save
     * @return the persisted entity
     */
    MenuDTO save(MenuDTO menuDTO);

    /**
     * Get all the tailleBalles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<MenuDTO> findAll(Pageable pageable);


    /**
     * Get the "id" tailleBalle.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<MenuDTO> findOne(Long id);

    /**
     * Delete the "id" tailleBalle.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
