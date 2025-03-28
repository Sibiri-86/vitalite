package com.vitalite.vitalite.model;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Agent entity.
 */
public class DroitProfileDTO {

    private Long id;

    private String profile;
    private String menu;
    private Long menuId;

    private Long profileId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

   

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    @Override
    public String toString() {
        return "DroitProfileDTO [id=" + id + ", profile=" + profile + ", menu=" + menu + ", menuId=" + menuId
                + ", profileId=" + profileId + "]";
    }
    
    

   

   
}
