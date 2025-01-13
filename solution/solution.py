from typing import List
from pydantic import BaseModel

class IndicatorRequest(BaseModel):
    id: int
    pourcentage: float

indicateurs_financiers = (
    {
        "id": 1,
        "libelle": "Marge nette",
        "seuils": {
            "bas": {"max": 0.05, "description": "< 5%"},
            "moyen": {"min": 0.05, "max": 0.10, "description": "5% à 10%"},
            "élevé": {"min": 0.10, "description": "> 10%"}
        }
    },
    {
        "id": 2,
        "libelle": "Retour sur actifs (ROA)",
        "seuils": {
            "bas": {"max": 0.05, "description": "< 5%"},
            "moyen": {"min": 0.05, "max": 0.10, "description": "5% à 10%"},
            "élevé": {"min": 0.10, "description": "> 10%"}
        }
    },
    {
        "id": 3,
        "libelle": "Retour sur capitaux propres (ROE)",
        "seuils": {
            "bas": {"max": 0.10, "description": "< 10%"},
            "moyen": {"min": 0.10, "max": 0.20, "description": "10% à 20%"},
            "élevé": {"min": 0.20, "description": "> 20%"}
        }
    },
    {
        "id": 4,
        "libelle": "Ratio de liquidité générale",
        "seuils": {
            "critique": {"max": 1.0, "description": "< 1"},
            "sécurité": {"min": 1.0, "max": 2.0, "description": "1 à 2"},
            "confortable": {"min": 2.0, "description": "> 2"}
        }
    },
    {
        "id": 5,
        "libelle": "Ratio de liquidité réduite",
        "seuils": {
            "critique": {"max": 1.0, "description": "< 1"},
            "sécurité": {"min": 1.0, "max": 1.5, "description": "1 à 1,5"},
            "confortable": {"min": 1.5, "description": "> 1,5"}
        }
    },
    {
        "id": 6,
        "libelle": "Ratio d'endettement global",
        "seuils": {
            "critique": {"min": 0.70, "description": "> 70%"},
            "raisonnable": {"min": 0.50, "max": 0.70, "description": "50% à 70%"},
            "bas": {"max": 0.50, "description": "< 50%"}
        }
    },
    {
        "id": 7,
        "libelle": "Couverture des intérêts",
        "seuils": {
            "critique": {"max": 1.5, "description": "< 1,5"},
            "sécurité": {"min": 1.5, "max": 3.0, "description": "1,5 à 3"},
            "confortable": {"min": 3.0, "description": "> 3"}
        }
    }
)

def determine_seuil(indicateur, pourcentage):
    seuils = indicateur["seuils"]
    for seuil, valeurs in seuils.items():
        if "min" in valeurs and "max" in valeurs:
            if valeurs["min"] <= pourcentage <= valeurs["max"]:
                return seuil
        elif "max" in valeurs and pourcentage <= valeurs["max"]:
            return seuil
        elif "min" in valeurs and pourcentage > valeurs["min"]:
            return seuil
    return None

def build_phrase(indicateur, pourcentage):
    libelle = indicateur["libelle"]
    seuil = determine_seuil(indicateur, pourcentage)
    phrase = (
        f"J'ai un état financier, sur {libelle}, j'ai un seuil {seuil.capitalize()}, "
        f"donne-moi des solutions, au moins 3, pour améliorer {libelle}."
    )
    return phrase

def build_phrase_global(indicators: List[IndicatorRequest]):
    phrases = []
    for indicator in indicators:
        id_indicateur = indicator.id
        pourcentage = indicator.pourcentage

        # Trouver l'indicateur correspondant dans indicateurs_financiers
        indicateur = next((i for i in indicateurs_financiers if i["id"] == id_indicateur), None)
        if not indicateur:
            phrases.append(f"Indicateur avec l'ID {id_indicateur} non trouvé.")
            continue

        # Déterminer le seuil
        seuil = determine_seuil(indicateur, pourcentage)

        # Construire la phrase pour cet indicateur
        libelle = indicateur["libelle"]
        phrase = (
            f"Sur {libelle}, j'ai un seuil {seuil.capitalize()} ({pourcentage}%), "
        )
        phrases.append(phrase)

    phrase_globale = "J'ai un état financier. " + " ".join(phrases) + ". Donne moi au moins 3 solutions pour améliorer mon état financier"
    return phrase_globale
