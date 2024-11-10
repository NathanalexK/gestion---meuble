package com.source.meuble.talent.offreEmploi;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "moyen_pub")
public class MoyenPub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moyen_pub", nullable = false)
    private Integer id;

    @Column(name = "libelle", nullable = false, length = 50)
    private String libelle;

    @Column(name = "prix", nullable = false, precision = 18, scale = 2)
    private BigDecimal prix;

}