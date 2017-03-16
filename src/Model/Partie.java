package Model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("dbb65517-e717-4f97-a9aa-5f6b73991f10")
public class Partie extends Thread{
    
	@objid ("256e170e-800d-462e-aef0-4b1aa4e3bbba")
    public Integer nbCartes;
    @objid ("e67a72c1-5a43-4484-b0a7-5301aa7760bc")
    public Integer nbCases;
    @objid ("5642bfe6-1f87-4f9f-b878-4dc4df67bc19")
    public Integer nbJoueur;
    @objid ("f6580126-2d9d-4a55-b147-ae84a56a1b7e")
    public Integer niveau_IA ;
    public boolean win = false;


    @objid ("62dc3ee3-628f-4d9e-8021-74c64e79ea09")
    public void initPartie() {
    	// charger la cr�ation du plateau du point de vu des donn�es
    	// instancier les �l�ments de jeu (cartes, jetons , ...)
    	// cr�ation des joueurs
    }

    @objid ("404ad5cc-66fb-4346-b0d9-b42a3b82f1b3")
    public Partie(Integer nbJoueurs, Integer niv_IA) {
        super();
        this.nbJoueur = nbJoueurs;
        this.niveau_IA = niv_IA;
    }

    @objid ("566927eb-7636-4ef3-a598-dd043944eb03")
    public Integer getNbCartes() {
        return nbCartes;
    }

    @objid ("ae3fd9ab-4095-478c-8c6c-9812e9e3222c")
    public void setNbCartes(Integer nbCartes) {
        this.nbCartes = nbCartes;
    }

    @objid ("c05b5707-6df3-4fc1-8ce1-7d2499beb3d2")
    public Integer getNbCases() {
        return nbCases;
    }

    @objid ("84f84d51-8e34-4354-9f1b-a40800a739ad")
    public void setNbCases(Integer nbCases) {
        this.nbCases = nbCases;
    }

    @objid ("0f9c6784-707c-4e5f-bbfa-8535a6d697fe")
    public void choixNbJoueur() {
    }

    @objid ("0341db70-3352-43ce-a92a-a01bdb67f33e")
    public void nextTour() {
    }
    

    
    public void run(){
    	initPartie(); // on initialise les �l�ment de base du jeu
    	
    	//cr�ation des joueurs
    	
    	
    	
    	while(win == false){
    		
    	}
    	
    }

}
