package com.source.meuble.utilisateur;

import com.source.meuble.mock.SidebarMock;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "id_role")
    UserRole role;


    public Utilisateur() {

    }

    public Utilisateur(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public boolean hasRole(UserRole... roles) {
        if(roles.length == 0) return true;

        for(UserRole role: roles) {
            if(this.getRole() == role) {
                return true;
            }
        }

        return false;
    }

    public String getSidebar(String currentUrl) {
        return SidebarMock.DEFAULT_SIDEBAR.getHtml(this, currentUrl);
    }

}
