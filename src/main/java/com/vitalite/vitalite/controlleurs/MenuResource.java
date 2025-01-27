package com.vitalite.vitalite.controlleurs;

import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vitalite.vitalite.controlleurs.util.HeaderUtil;
import com.vitalite.vitalite.controlleurs.util.PaginationUtil;
import com.vitalite.vitalite.model.MenuDTO;
import com.vitalite.vitalite.services.MenuService;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing TailleBalle.
 */
@RestController
@RequestMapping("/api")
public class MenuResource {

    private final Logger log = LoggerFactory.getLogger(MenuResource.class);

    private static final String ENTITY_NAME = "menus";

    private final MenuService menuService;

    public MenuResource(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * POST  /taille-balles : Create a new tailleBalle.
     *
     * @param menuDTO the tailleBalleDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tailleBalleDTO, or with status 400 (Bad Request) if the tailleBalle has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/menus")
    public ResponseEntity<MenuDTO> createMenu(@RequestBody MenuDTO menuDTO) throws URISyntaxException {
        log.debug("REST request to save TailleBalle : {}", menuDTO);
       
        MenuDTO result = menuService.save(menuDTO);
        return ResponseEntity.created(new URI("/api/menus/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /taille-balles : Updates an existing tailleBalle.
     *
     * @param menuDTO the tailleBalleDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tailleBalleDTO,
     * or with status 400 (Bad Request) if the tailleBalleDTO is not valid,
     * or with status 500 (Internal Server Error) if the tailleBalleDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/menus")
    public ResponseEntity<MenuDTO> updateMenu(@RequestBody MenuDTO menuDTO) throws URISyntaxException {
        log.debug("REST request to update TailleBalle : {}", menuDTO);
      
        MenuDTO result = menuService.save(menuDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, menuDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /taille-balles : get all the tailleBalles.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of tailleBalles in body
     */
    @GetMapping("/menus")
    public ResponseEntity<List<MenuDTO>> getAllMenu(Pageable pageable) {
        log.debug("REST request to get a page of TailleBalles");
        Page<MenuDTO> page = menuService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/menus");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /taille-balles/:id : get the "id" tailleBalle.
     *
     * @param id the id of the tailleBalleDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tailleBalleDTO, or with status 404 (Not Found)
     */
    @GetMapping("/menus/{id}")
    public ResponseEntity<MenuDTO> getMenu(@PathVariable Long id) {
        log.debug("REST request to get TailleBalle : {}", id);
        Optional<MenuDTO> menuDTO = menuService.findOne(id);
        return null;
    }

    /**
     * DELETE  /taille-balles/:id : delete the "id" tailleBalle.
     *
     * @param id the id of the tailleBalleDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/menus/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        log.debug("REST request to delete TailleBalle : {}", id);
        menuService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
