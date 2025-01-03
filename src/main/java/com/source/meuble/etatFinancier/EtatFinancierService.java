package com.source.meuble.etatFinancier;

import com.source.meuble.etatFinancier.Poste.PosteCpl;
import com.source.meuble.etatFinancier.Poste.PosteCplRepository;
import com.source.meuble.etatFinancier.Poste.PosteRepository;
import com.source.meuble.etatFinancier.Poste.Poste;
import com.source.meuble.etatFinancier.posteFille.PosteFille;
import com.source.meuble.etatFinancier.posteFille.PosteFilleRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EtatFinancierService {

    private final PosteRepository posteRepository;
    private final PosteFilleRepository posteFilleRepository;
    private final PosteCplRepository posteCplRepository;
    private final JdbcTemplate jdbcTemplate;

    public EtatFinancierService(PosteRepository posteRepository,
                                PosteFilleRepository posteFilleRepository,
                                PosteCplRepository posteCplRepository, JdbcTemplate jdbcTemplate) {
        this.posteRepository = posteRepository;
        this.posteFilleRepository = posteFilleRepository;
        this.posteCplRepository = posteCplRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public EtatFinancierDTO build() {
        EtatFinancierDTO ef = new EtatFinancierDTO();
        List<PosteCpl> bilan = posteCplRepository.findByIdMere_CategorieLessThanEqual(1);
        List<PosteCpl> resultat = posteCplRepository.findByIdMere_Categorie(2);

        ef.setResultatNet(resultat.get(0).getTotal() - resultat.get(1).getTotal());
        ef.setBilan(bilan);
        ef.setResultat(resultat);

        ef.setTotaux(getActif());
        checkValidite(ef);
        return ef;
    }

    public List<Double> getActif() {
        String sql = """
                select categorie,sum(montant) from poste_fille
                join poste on poste_fille.id_mere = poste.id_poste
                group by categorie
                order by categorie asc;""";

        List<Double> result = new ArrayList<>();
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                result.add( ((BigDecimal) rs.getObject(2)).doubleValue());
            }
        });

        return result;
    }

    public void checkValidite(EtatFinancierDTO etatFinancier) {
        Double actif = etatFinancier.getTotaux().get(0);
        Double passif = etatFinancier.getTotaux().get(1);
        if (!Objects.equals(actif, passif)) {
            etatFinancier.setValidite(false);

            if ( actif > passif)
                etatFinancier.setMessageValidite("Actif " + actif + " > passif " + passif );
            else
                etatFinancier.setMessageValidite("Actif " + actif + " < passif " + passif );
        }
    }

    public void construct() {
        PosteFille chargeExpl = posteFilleRepository.findByLibelle("Charges d’exploitation").get(0);
        PosteFille chargeFinan = posteFilleRepository.findByLibelle("Charges financières").get(0);
        PosteFille impot = posteFilleRepository.findByLibelle("Charges financières").get(0);
    }
}
