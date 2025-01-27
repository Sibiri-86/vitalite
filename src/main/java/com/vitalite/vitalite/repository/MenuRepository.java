package com.vitalite.vitalite.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.vitalite.vitalite.security.Menu;


/**
 * Spring Data  repository for the TailleBalle entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Page<Menu>findAllByDeletedFalse(Pageable pageable);

}
