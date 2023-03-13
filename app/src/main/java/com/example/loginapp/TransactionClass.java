package com.example.loginapp;

public class TransactionClass  {

    Integer iamge;
    String Titre;

    public TransactionClass(Integer iamge, String titre) {
        this.iamge = iamge;
        Titre = titre;
    }

    public Integer getIamge() {
        return iamge;
    }

    public void setIamge(Integer iamge) {
        this.iamge = iamge;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }


}
