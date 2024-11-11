package com.source.meuble.talent.test.resultatTest;

import com.source.meuble.talent.test.Test;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "resultat_test")
public class ResultatTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultat_test", nullable = false)
    private Integer id;

    @Column(name = "points")
    private Double points;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_test", nullable = false)
    private Test idTest;

}