package com.vitalite.vitalite.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.Mapper;
import com.vitalite.vitalite.entities.Profile;
import com.vitalite.vitalite.model.ProfileDTO;
import com.vitalite.vitalite.repository.ProfileRepository;
import com.vitalite.vitalite.services.ProfileService;

import java.util.Optional;

/**
 * Service Implementation for managing TailleBalle.
 */
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    private final Logger log = LoggerFactory.getLogger(ProfileServiceImpl.class);

    private final ProfileRepository profileRepository;

    
    private final Mapper profileMapper ;

    public ProfileServiceImpl(ProfileRepository profileRepository,Mapper profileMapper) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
    }

    /**
     * Save a tailleBalle.
     *
     * @param profileDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ProfileDTO save(ProfileDTO profileDTO) {
        log.debug("Request to save TailleBalle : {}", profileDTO);
        Profile profile = profileMapper.map(profileDTO, Profile.class);
        
        profile = profileRepository.save(profile);
        return profileMapper.map(profile, ProfileDTO.class);
    }

    /**
     * Get all the tailleBalles.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProfileDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TailleBalles");
        return profileRepository.findAllByDeletedFalse(pageable)
            .map(menu->profileMapper.map(menu,ProfileDTO.class));
    }


    /**
     * Get one tailleBalle by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ProfileDTO> findOne(Long id) {
        log.debug("Request to get TailleBalle : {}", id);
        return profileRepository.findById(id)
            .map(profil->profileMapper.map(profil,ProfileDTO.class));
    }

    /**
     * Delete the tailleBalle by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TailleBalle : {}", id);
        profileRepository.deleteById(id);
    }
}
