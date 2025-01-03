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

    //2.
    public Double getRetourSurActif() {
        return this.getResultatNet() / this.getTotalActifs() * 100;
    }

    //3.
    public Double getRetourSurCapitauxPropres() {
        return this.getActifCourant() / this.getCapitauxPropres() * 100;
    }

    //4.
    public Double getRationLiquiditeGeneral() {
        return this.getActifCourant() / this.getPassifCourrant();
    }

    //5.
    public Double getRatioLiquiditeReduite() {
        return (this.getActifCourant() - this.getValeurStock()) / this.getPassifCourrant();
    }

    //6.
    public Double getRatioEndettementGlobal() {
        return this.getTotalDettes() / this.getTotalActifs() * 100;
    }

    //7.
    public Double getCouvertureDesInterets() {
        return this.getResultatExploitation() / this.getChargeFinanciere();
    }
}
