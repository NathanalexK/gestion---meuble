package com.source.meuble.etatFinancier.Poste;

import com.source.meuble.etatFinancier.posteFille.PosteFille;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "poste_cpl")
public class PosteCpl {
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mere")
    private Poste idMere;

    @Column(name = "total")
    private Double total;

}