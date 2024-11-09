package com.source.meuble.talent.diplome;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_diplome;
    private String libelle;
    private int niveau;

    @Override
    public String toString() {
        return "Diplome{" +
                "id_diplome=" + id_diplome +
                ", libelle='" + libelle + '\'' +
                ", niveau=" + niveau +
                '}';
    }
}
