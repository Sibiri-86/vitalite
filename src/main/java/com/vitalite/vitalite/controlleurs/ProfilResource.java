package com.vitalite.vitalite.controlleurs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vitalite.vitalite.entities.Profil;
import com.vitalite.vitalite.model.AuthorityDto;
import com.vitalite.vitalite.model.ProfilDto;
import com.vitalite.vitalite.services.ProfilService;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfilResource {
    private final Logger log = LoggerFactory.getLogger(ProfilResource.class);



    private final ProfilService profilService;

    public ProfilResource(ProfilService profilService) {
        this.profilService = profilService;
    }

    /**
     * {@code POST  /profils} : Create a new profil.
     *
     * @param profil the profil to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new profilDTO, or with status {@code 400 (Bad Request)} if the profil has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/profils")
    public ResponseEntity<Profil> createProfil(@Valid @RequestBody ProfilDto profil) throws URISyntaxException {
        log.debug("REST request to save Profil : {}", profil);
       
        return new ResponseEntity<>(profilService.save(profil), HttpStatus.CREATED);
    }

    /**
     * {@code PUT  /profils} : Updates an existing profil.
     *
     * @param profil the profil to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated profil,
     * or with status {@code 400 (Bad Request)} if the profil is not valid,
     * or with status {@code 500 (Internal Server Error)} if the profil couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/profils")
    public ResponseEntity<Profil> updateProfil(@Valid @RequestBody ProfilDto profil) throws URISyntaxException {
        log.debug("REST request to update Profil : {}", profil);
        
         return new ResponseEntity<>(profilService.save(profil), HttpStatus.CREATED);

       
    }

    /**
     * {@code GET  /profils} : get all the profils.
     *
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of profils in body.
     */
    @GetMapping("/profils")
    public List<Profil> getAllProfils(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all Profils");
        System.out.println("profil getting 1 ====> "+ profilService.findAll());
        return profilService.findAll();
    }

    @GetMapping("/profils/by-authorities")
    public List<AuthorityDto> findAllAuthorities(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all Profils");
        return profilService.findAllAuthorities();
    }

    /**
     * {@code GET  /profils/:id} : get the "id" profil.
     *
     * @param id the id of the profil to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the profil, or with status {@code 404 (Not Found)}.
     */
  /*   @GetMapping("/profils/{id}")
    public ResponseEntity<Profil> getProfil(@PathVariable Long id) {
        log.debug("REST request to get Profil : {}", id);
        return new ResponseEntity<>(profilService.findOne(id), HttpStatus.CREATED);
    }
*/
    /**
     * {@code DELETE  /profils/:id} : delete the "id" profil.
     *
     * @param id the id of the profil to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
  /*   @DeleteMapping("/profils/{id}")
    public ResponseEntity<Void> deleteProfil(@PathVariable Long id) {
        log.debug("REST request to delete Profil : {}", id);
        profilService.delete(id);
    }*/
}
