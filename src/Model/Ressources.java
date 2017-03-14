package Model;

import java.io.Serializable;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ba938f9d-688a-401d-8014-5f841fbaa790")
public class Ressources implements Serializable{
    @objid ("b0773b97-21ba-4bd6-9357-6c2ffabae5bb")
    public String nom;

    @objid ("e9c14a94-5b77-41a4-b9b8-c0592362b59f")
    public Integer nbRess;

    @objid ("c069ce03-7504-4549-b528-f4e34962aefd")
    public Ressources(String nom, Integer nbRess) {
        super();
        this.nom = nom;
        this.nbRess = nbRess;
    }

    @objid ("dafa64b8-0ba5-4ff1-ab69-16d7c31edcce")
    public String getNom() {
        return nom;
    }

    @objid ("631e455f-ea66-4611-ab52-96757719d6e7")
    public void setNom(String nom) {
        this.nom = nom;
    }

    @objid ("325e1a5e-2bd8-4c66-b36e-b2b121237688")
    public Integer getNbRess() {
        return nbRess;
    }

    @objid ("9b440314-0067-46b8-b360-6be9b7e97e05")
    public void setNbRess(Integer nbRess) {
        this.nbRess = nbRess;
    }
    
    public void retirer_item()
    {
    	this.nbRess -= 1 ;
    }

}
