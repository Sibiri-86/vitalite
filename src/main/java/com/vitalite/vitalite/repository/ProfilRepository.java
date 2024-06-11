package com.vitalite.vitalite.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vitalite.vitalite.entities.Profil;

import java.util.List;
import java.util.Optional;

public interface ProfilRepository extends JpaRepository<Profil, Long> {
    @Query(value = "select distinct profil from Profil profil left join fetch profil.authorities",
        countQuery = "select count(distinct profil) from Profil profil")
    Page<Profil> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct profil from Profil profil left join fetch profil.authorities")
    List<Profil> findAllWithEagerRelationships();

    @Query("select profil from Profil profil left join fetch profil.authorities where profil.id =:id")
    Optional<Profil> findOneWithEagerRelationships(@Param("id") Long id);
}
