package com.vitalite.vitalite.implement;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.Mapper;
import com.vitalite.vitalite.model.DroitProfileDTO;
import com.vitalite.vitalite.repository.DroitProfileRepository;
import com.vitalite.vitalite.security.DroitProfile;
import com.vitalite.vitalite.services.DroitProfileService;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Agent.
 */
@Service
@Transactional
public class DroitProfileServiceImpl implements DroitProfileService {

    private final Logger log = LoggerFactory.getLogger(DroitProfileServiceImpl.class);

    private final DroitProfileRepository droitProfileRepository;

   // private final DroitProfileMapper droitProfileMapper;
    @Autowired
     private Mapper mapper;

    public DroitProfileServiceImpl(DroitProfileRepository droitProfileRepository) {
        this.droitProfileRepository = droitProfileRepository;
    }

    /**
     * Save a agent.
     *
     * @param agentDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DroitProfileDTO save(DroitProfileDTO droitProfileDTO) {
        log.debug("Request to save Agent : {}", droitProfileDTO);
        DroitProfile droitProfile = mapper.map(droitProfileDTO,DroitProfile.class );
        
        droitProfile = droitProfileRepository.save(droitProfile);
        return mapper.map(droitProfile,DroitProfileDTO.class);
    }

    /**
     * Get all the agents.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DroitProfileDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Agents");
        return droitProfileRepository.findAllByDeletedFalse(pageable)
            .map(droitProfile->mapper.map(droitProfile,DroitProfileDTO.class));
    }


    /**
     * Get one agent by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DroitProfileDTO> findOne(Long id) {
        log.debug("Request to get Agent : {}", id);
        return droitProfileRepository.findById(id)
            .map(droitProfile->mapper.map(droitProfile,DroitProfileDTO.class));
    }

    /**
     * Delete the agent by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Agent : {}", id);
        droitProfileRepository.deleteById(id);
    }
    
     public List<DroitProfileDTO> findAllByProfile(Long profileId) {
          return droitProfileRepository.findByProfileIdAndDeletedFalse(profileId).stream()
            .map(droitProfile->mapper.map(droitProfile,DroitProfileDTO.class)).collect(Collectors.toList());
     }
}
