package com.source.meuble.etatFinancier.bilan;

import com.source.meuble.etatFinancier.posteFille.PosteFille;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Setter
public class BilanEtatFinancierImpl extends BilanEtatFinancier {
    // private List<PosteFille> posteFilles;
    private JdbcTemplate jdbcTemplate;
    private int idExercice;

    Double revenu;
    Double benefice;
    Double resultatNet;
    Double totalActifs;
    Double totalPassifs;
    Double passifCourant;
    Double actifCourant;
    Double totalDettes;
    Double chargesFinanciere;
    Double resultatExploitation;
    Double capitauxPropres;
    Double valeurStock;

    public BilanEtatFinancierImpl(JdbcTemplate jdbcTemplate, int idExercice) {
        // this.setPosteFilles(posteFilles);
        this.jdbcTemplate = jdbcTemplate;
        this.idExercice = idExercice;

        initRevenu();
        initBenefice();
        initResultatNet();
        initTotalActifs();
        initTotalPassifs();
        initPassifCourrant();
        initActifCourant();
        initTotalDettes();
        initChargeFinanciere();
        initResultatExploitation();
        initCapitauxPropres();
        initValeurStock();
    }

    Double fetchMontant(String sql) {
        return jdbcTemplate.query(sql, rs -> rs.next() ? rs.getDouble("montant") : 0);
    }

    public void initRevenu() {
        String sql = "select sum(montant) as montant from poste_fille where id_mere = 5 and id_exercice =" + idExercice;
        setRevenu(fetchMontant(sql));
    }

    Double initBenefice() {
        // TODO: Implementation Benfice
        setBenefice(0.0);
        return 0.0;
    }

    Double initResultatNet() {
        String sql = "select (select sum(montant) as montant from poste_fille where id_mere = 5 and id_exercice ="
                + idExercice + ")" +
                " - (select sum(montant) as montant from poste_fille where id_mere = 6 and id_exercice =" + idExercice
                + ") as montant";
        setResultatNet(fetchMontant(sql));
        return resultatNet;
    }

    Double initTotalActifs() {
        String sql = "select sum(montant) as montant from poste_fille where id_mere in (select id_poste from poste where categorie = 0) and id_exercice = "
                + idExercice;
        setTotalActifs(fetchMontant(sql));
        return totalActifs;
    }

    Double initTotalPassifs() {
        String sql = "select sum(montant) as montant from poste_fille where id_mere in (select id_poste from poste where categorie = 1) and id_exercice = "
                + idExercice;
        setTotalPassifs(fetchMontant(sql));
        return totalPassifs;
    }

    Double initPassifCourrant() {
        String sql = "select sum(montant) as montant from poste_fille where id_mere=4 and id_exercice=" + idExercice;
        setPassifCourant(fetchMontant(sql));
        return passifCourant;
    }

    Double initActifCourant() {
        String sql = "select sum(montant) as montant from poste_fille where id_mere=2 and id_exercice=" + idExercice;
        setActifCourant(fetchMontant(sql));
        return actifCourant;
    }

    Double initTotalDettes() {
        String sql = """
                SELECT sum(montant) as montant
                FROM poste_fille
                WHERE (LOWER(libelle) LIKE '%dette%'
                   OR LOWER(libelle) LIKE '%emprunt%'
                   OR LOWER(libelle) LIKE '%fournisseurs%')
                AND id_exercice=""" + idExercice;
        setTotalDettes(fetchMontant(sql));
        return totalDettes;
    }

    Double initChargeFinanciere() {
        String sql = "select montant from poste_fille where libelle='Charges financières' and id_exercice="
                + idExercice;
        setChargesFinanciere(fetchMontant(sql));
        return chargesFinanciere;
    }

    Double initResultatExploitation() {
        String sql = "select (select montant from poste_fille where id_mere=5 and id_exercice=" + idExercice + ")" +
                "- (select montant from poste_fille where libelle='Charges d’exploitation' and id_exercice="
                + idExercice + ") as montant;";
        setResultatExploitation(fetchMontant(sql));
        return resultatExploitation;
    }

    Double initCapitauxPropres() {
        String sql = "select sum(montant) as montant from poste_fille where id_mere=7 and id_exercice=" + idExercice;
        setCapitauxPropres(fetchMontant(sql));
        return capitauxPropres;
    }

    Double initValeurStock() {
        String sql = """
                SELECT sum(montant) as montant
                FROM poste_fille
                WHERE (LOWER(libelle) LIKE '%stock%')
                AND id_exercice=""" + idExercice;
        setValeurStock(fetchMontant(sql));
        return valeurStock;
    }

    @Override
    public Double getRevenu() {
        return revenu;
    }

    @Override
    public Double getBenefice() {
        return benefice;
    }

    @Override
    public Double getResultatNet() {
        return resultatNet;
    }

    @Override
    public Double getTotalActifs() {
        return totalActifs;
    }

    @Override
    public Double getTotalPassifs() {
        return totalPassifs;
    }

    @Override
    public Double getPassifCourrant() {
        return passifCourant;
    }

    @Override
    public Double getActifCourant() {
        return actifCourant;
    }

    @Override
    public Double getTotalDettes() {
        return totalDettes;
    }

    @Override
    public Double getChargeFinanciere() {
        return chargesFinanciere;
    }

    @Override
    public Double getResultatExploitation() {
        return resultatExploitation;
    }

    @Override
    public Double getCapitauxPropres() {
        return capitauxPropres;
    }

    @Override
    public Double getValeurStock() {
        return valeurStock;
    }
}
