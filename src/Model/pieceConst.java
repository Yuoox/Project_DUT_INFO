package Model;

import java.io.Serializable;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("9d61082a-d6b4-4ef4-99f7-8a804033078a")
public class pieceConst implements Serializable {
    @objid ("1a8f7a49-d3c6-411a-9ab9-120cd3718ab5")
    public String nom;

    @objid ("4b82a012-9f0e-4724-b693-867c23fc98c7")
    public Integer nbPiece;

	public pieceConst(String nom, Integer nbPiece) {
		super();
		this.nom = nom;
		this.nbPiece = nbPiece;
	}
    
    

}
