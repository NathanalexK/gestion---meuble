package com.source.meuble.etatFinancier.posteFille.PosteFilleValue;

import com.source.meuble.analytique.exercice.Exercice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "poste_fille_value")
public class PosteFilleValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer compte;

    @Column(name = "montant")
    private Double montant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_exercice")
    private Exercice idExercice;

    public void setCompte(String s)throws Exception{
        Integer i = Integer.parseInt(s);
        this.setCompte(i);
    }

    public void setCompte(Integer i){
        this.compte = i;
    }

    public void setMontant(String s)throws Exception{
        Double i = Double.parseDouble(s);
        this.setMontant(i);
    }

    public void setMontant(Double i){
        this.montant = i;
    }

}
