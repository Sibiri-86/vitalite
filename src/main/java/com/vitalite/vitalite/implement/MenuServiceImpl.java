package com.vitalite.vitalite.implement;

import com.vitalite.vitalite.services.MenuService;
import com.vitalite.vitalite.services.ProfileService;
import com.github.dozermapper.core.Mapper;
import com.vitalite.vitalite.entities.Authority;
import com.vitalite.vitalite.model.DroitProfileDTO;
import com.vitalite.vitalite.model.MenuDTO;
import com.vitalite.vitalite.repository.MenuRepository;
import com.vitalite.vitalite.repository.ProfileRepository;
import com.vitalite.vitalite.repository.UserRepository;
import com.vitalite.vitalite.security.Menu;
import com.vitalite.vitalite.security.User;

import org.hibernate.envers.Audited;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing TailleBalle.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    private final Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);

    private final MenuRepository menuRepository;

    @Autowired
    Mapper mapper;
    @Autowired
    UserRepository userRepository; 

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    /**
     * Save a tailleBalle.
     *
     * @param menuDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MenuDTO save(MenuDTO menuDTO) {
        log.debug("Request to save TailleBalle : {}", menuDTO);
        Menu menu = mapper.map(menuDTO, Menu.class);
        
        menu = menuRepository.save(menu);
        return mapper.map(menu, MenuDTO.class);
    }

    /**
     * Get all the tailleBalles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
   // @Transactional(readOnly = true)
    public Page<MenuDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TailleBalles");
        if(menuRepository.findAllByDeletedFalse(pageable).toList().isEmpty()) {
            Optional<User> user = userRepository.findOneByEmail("dambrelaurent82@gmail.com");
            List<Authority> authorities1= user.map(user1 -> new ArrayList<>(user1.getProfils().stream().findFirst().get()
            .getAuthorities())).orElse(null);
            if(!authorities1.isEmpty()) {
                int i =1;
                for(Authority a: authorities1) {
                    MenuDTO menu = new MenuDTO();
                   
                    menu.setCode(a.getName());
                    menu.setLibelle(a.getName());
                    save(menu);
                }
            } 
        }
        
        return menuRepository.findAllByDeletedFalse(pageable)
            .map(menu->mapper.map(menu,MenuDTO.class));
    }


    /**
     * Get one tailleBalle by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<MenuDTO> findOne(Long id) {
        log.debug("Request to get TailleBalle : {}", id);
        return menuRepository.findById(id)
            .map(menu->mapper.map(menu,MenuDTO.class));
    }

    /**
     * Delete the tailleBalle by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TailleBalle : {}", id);
        menuRepository.deleteById(id);
    }
}
