package com.vitalite.vitalite.model;

import java.util.HashSet;
import java.util.Set;

import com.vitalite.vitalite.entities.Authority;

public class ProfilDto {
    private Long id;
    private String profilName;
    private Set<Authority> authorities = new HashSet<>();
    private Boolean deleted = Boolean.FALSE;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProfilName() {
        return profilName;
    }
    public void setProfilName(String profilName) {
        this.profilName = profilName;
    }
    public Set<Authority> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

   
    

      
}
