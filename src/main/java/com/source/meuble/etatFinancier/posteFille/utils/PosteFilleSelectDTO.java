package com.source.meuble.etatFinancier.posteFille.utils;

public class PosteFilleSelectDTO {
    public Integer compte;
    public String libelle;

    public PosteFilleSelectDTO(Integer compte, String s){
        this.compte = compte;
        this.libelle = s;
    }
}
