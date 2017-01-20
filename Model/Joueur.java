package Model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("540b8af8-a737-4b2b-9d77-9335754f9d00")
public class Joueur {
    @objid ("becc1880-44cd-438d-b838-c7c73497287e")
    public Integer idJoueur;

    @objid ("dcf77b8b-f8f7-4a0b-8c56-fa61fdd8933b")
    public String nom;

    @objid ("2e018a41-c61f-418f-a9cf-dab55c0f45d8")
    public boolean actif;

    @objid ("6d52fac0-d6ce-4f6a-98a5-338a6d63db11")
    public Joueur(Integer idJoueur, String nom, boolean actif) {
        super();
        this.idJoueur = idJoueur;
        this.nom = nom;
        this.actif = actif;
    }

    @objid ("5d4d848c-a01b-45c7-bb80-2c9428554caf")
    public Integer getIdJoueur() {
        return idJoueur;
    }

    @objid ("748374ec-2de9-4ecc-af98-701f17b03e41")
    public void setIdJoueur(Integer idJoueur) {
        this.idJoueur = idJoueur;
    }

    @objid ("94f04583-e79f-4666-8089-4356a40994e2")
    public String getNom() {
        return nom;
    }

    @objid ("31c856ea-0131-4e4f-a82f-f6c60f4db03f")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @objid ("4bdb23c8-57aa-4348-95d7-5b8882a279ab")
    public boolean isActif() {
        return actif;
    }

    @objid ("3d945f37-554e-4986-b7da-699b5684f415")
    public void setActif(boolean actif) {
        this.actif = actif;
    }

    @objid ("81b27145-e8ef-4b20-8592-36c292c31b07")
    public void checkCase() {
    }

}
