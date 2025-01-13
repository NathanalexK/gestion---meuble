package com.source.meuble.etatFinancier.bilan;


public abstract class BilanEtatFinancier {

    abstract Double getRevenu();
    abstract Double getBenefice();
    abstract Double getResultatNet();
    abstract Double getTotalActifs();
    abstract Double getTotalPassifs();
    abstract Double getPassifCourrant();
    abstract Double getActifCourant();
    abstract Double getTotalDettes();
    abstract Double getChargeFinanciere();
    abstract Double getResultatExploitation();
    abstract Double getCapitauxPropres();
    abstract Double getValeurStock();

    //1.
    public Double getMargeNette() {
        return this.getBenefice() / this.getRevenu() * 100;
    }

    public Seuil getSeuilMargeNette(){
        Double margeNette = this.getMargeNette();
        if(margeNette < 5) return Seuil.BAS;
        if(margeNette < 10) return Seuil.MOYEN;
        return Seuil.ELEVE;
    }

    //2.
    public Double getRetourSurActif() {
        return this.getResultatNet() / this.getTotalActifs() * 100;
    }

    public Seuil getSeuilRetourSurActif() {
        Double roa = this.getRetourSurActif();
        if(roa < 5) return Seuil.BAS;
        if(roa < 10) return Seuil.MOYEN;
        return Seuil.ELEVE;
    }

    //3.
    public Double getRetourSurCapitauxPropres() {
        return this.getActifCourant() / this.getCapitauxPropres();
    }

    public Seuil getSeuilRetourSurCapitauxPropres() {
        Double roe = this.getRetourSurCapitauxPropres();
        if(roe < 10) return Seuil.BAS;
        if(roe < 20) return Seuil.MOYEN;
        return Seuil.ELEVE;
    }

    //4.
    public Double getRatioLiquiditeGeneral() {
        return this.getActifCourant() / this.getPassifCourrant();
    }

    public Seuil getSeuilRatioLiquiditeGeneral() {
         Double rlg = this.getRatioLiquiditeGeneral();
         if(rlg < 1) return Seuil.BAS;
         if(rlg < 2) return Seuil.MOYEN;
         return Seuil.ELEVE;
    }
    //5.
    public Double getRatioLiquiditeReduite() {
        return (this.getActifCourant() - this.getValeurStock()) / this.getPassifCourrant();
    }

    public Seuil getSeuilRatioLiquiditeReduite() {
        Double rlr = this.getRatioLiquiditeReduite();
        if(rlr < 1) return Seuil.BAS;
        if(rlr < 1.5) return Seuil.MOYEN;
        return Seuil.ELEVE;
    }

    //6.
    public Double getRatioEndettementGlobal() {
        return this.getTotalDettes() / this.getTotalActifs() * 100;
    }

    public Seuil getSeuilRatioEndettementGlobal() {
        Double reg = this.getRatioEndettementGlobal();
        if(reg > 70) return Seuil.BAS; // Seuil Critique
        if(reg > 50) return Seuil.MOYEN; // Seuil Raisonnable
        return Seuil.ELEVE; // Seuil Bas
    }

    //7.
    public Double getCouvertureDesInterets() {
        System.out.println("Resultat Exploitation: " + this.getResultatExploitation());
        System.out.println("Charge Financiere: " + this.getChargeFinanciere());
        return this.getResultatExploitation() / this.getChargeFinanciere();
    }

    public Seuil getSeuilCouverureDesInterets() {
        Double cdi = this.getCouvertureDesInterets();
        if(cdi < 1.5) return Seuil.BAS;
        if(cdi < 3) return Seuil.MOYEN;
        return Seuil.ELEVE;
    }
}
