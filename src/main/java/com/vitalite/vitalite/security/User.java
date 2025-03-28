package com.vitalite.vitalite.security;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vitalite.vitalite.entities.AbstractAuditingEntity;
import com.vitalite.vitalite.entities.Authority;
import com.vitalite.vitalite.entities.Produit;
import com.vitalite.vitalite.entities.Profil;
import com.vitalite.vitalite.entities.Profile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "_user")
public class User  implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
   
    private String activationKey;
    private String resetKey;
    private Instant resetDate = null;
    private boolean activated = false;
    private String langKey;
    @Column(name = "pass_change")
    private Boolean passChange;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("users")
    private Profile  profile;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "user_authority",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})

    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "jhi_user_profil",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "profil_id", referencedColumnName = "id")})
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @BatchSize(size = 20)
    private Set<Profil> profils = new HashSet<>();
   
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));   
    }
    
    @Override
    public String getUsername() {

        
        return email;
    }

    public Set<Authority> getAuthoritiesList() {
        return authorities;
    }
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }
    @Override
    public boolean isAccountNonLocked() {

        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;   
    }
    @Override
    public boolean isEnabled() {
        return true;    
    }
    @Override
    public String getPassword() {

        return password;
    }

    

}
