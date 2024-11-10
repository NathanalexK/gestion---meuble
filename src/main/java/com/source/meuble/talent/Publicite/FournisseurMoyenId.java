package com.source.meuble.talent.Publicite;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class FournisseurMoyenId implements Serializable {
    private static final long serialVersionUID = -635708152981695746L;
    @Column(name = "id_moyen_pub", nullable = false)
    private Integer idMoyenPub;

    @Column(name = "id_fournisseur_pub", nullable = false)
    private Integer idFournisseurPub;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FournisseurMoyenId entity = (FournisseurMoyenId) o;
        return Objects.equals(this.idMoyenPub, entity.idMoyenPub) &&
                Objects.equals(this.idFournisseurPub, entity.idFournisseurPub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMoyenPub, idFournisseurPub);
    }

}