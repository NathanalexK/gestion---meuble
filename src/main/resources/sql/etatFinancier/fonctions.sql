CREATE OR REPLACE FUNCTION calculer_montants_recurrents(
    v_compte INT,
    v_id_compte_mere INT
)
RETURNS VOID AS
$$
DECLARE
rec_poste_fille RECORD;
BEGIN
FOR rec_poste_fille IN
SELECT compte, montant
FROM poste_fille
WHERE id_compte_mere = v_compte
    LOOP
UPDATE temp_montants
SET somme_montant = somme_montant + rec_poste_fille.montant
WHERE id_compte_mere = v_id_compte_mere;

PERFORM calculer_montants_recurrents(
            rec_poste_fille.compte,
            v_id_compte_mere
        );
END LOOP;

    RETURN;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION calculer_somme_poste_fille()
RETURNS TABLE (id_compte_mere INT, somme_montant DECIMAL) AS
$$
DECLARE
rec_poste_fille RECORD;
BEGIN
    CREATE TEMP TABLE temp_montants (
        id_compte_mere INT PRIMARY KEY,
        somme_montant DECIMAL(15, 2) DEFAULT 0.00
    );

INSERT INTO temp_montants (id_compte_mere, somme_montant)
SELECT p.compte, p.montant
FROM poste_fille p
WHERE p.id_compte_mere IS NULL;

FOR rec_poste_fille IN
SELECT p.compte
FROM poste_fille p
WHERE p.id_compte_mere IS NULL
    LOOP
        PERFORM calculer_montants_recurrents(
            rec_poste_fille.compte,
            rec_poste_fille.compte
        );
END LOOP;

RETURN QUERY
SELECT t.id_compte_mere, t.somme_montant
FROM temp_montants t;

DROP TABLE temp_montants;

RETURN;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION calculer_montants_recurrents(
    v_compte INT,
    v_id_compte_mere INT
)
RETURNS VOID AS
$$
DECLARE
rec_poste_fille RECORD;
BEGIN
FOR rec_poste_fille IN
SELECT compte, montant, id_mere
FROM poste_fille
WHERE id_compte_mere = v_compte
    LOOP
UPDATE temp_montants
SET somme_montant = somme_montant + rec_poste_fille.montant
WHERE id_compte_mere = v_id_compte_mere;

PERFORM calculer_montants_recurrents(
            rec_poste_fille.compte,
            v_id_compte_mere
        );
END LOOP;

    RETURN;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION calculer_somme_poste_fille()
RETURNS TABLE (id_compte_mere INT, id_mere INT, somme_montant DECIMAL) AS
$$
DECLARE
rec_poste_fille RECORD;
BEGIN
    CREATE TEMP TABLE temp_montants (
        id_compte_mere INT PRIMARY KEY,
        id_mere INT,
        somme_montant DECIMAL(15, 2) DEFAULT 0.00
    );

INSERT INTO temp_montants (id_compte_mere, id_mere, somme_montant)
SELECT p.compte, p.id_mere, p.montant
FROM poste_fille p
WHERE p.id_compte_mere IS NULL;

FOR rec_poste_fille IN
SELECT p.compte, p.id_mere
FROM poste_fille p
WHERE p.id_compte_mere IS NULL
    LOOP
        PERFORM calculer_montants_recurrents(
            rec_poste_fille.compte,
            rec_poste_fille.compte
        );
END LOOP;

RETURN QUERY
SELECT t.id_compte_mere, t.id_mere, t.somme_montant
FROM temp_montants t;

DROP TABLE temp_montants;

RETURN;
END;
$$ LANGUAGE plpgsql;

select * from calculer_somme_poste_fille();