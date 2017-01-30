package Model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("eafe5f41-c3ba-493f-a3f8-488d32b31734")
public class Emplacement {
    @objid ("1b639e59-0325-44b2-8cd6-665fed0ce279")
    public Integer idEmplacement;

    @objid ("2231ebdc-27ac-4416-901e-720b69d2fdcf")
    public Integer ordonnee;

    @objid ("209e20a3-4269-4c17-8851-b2b97305ce46")
    public Integer abscisse;

    @objid ("bcb318cb-d824-45b0-aefc-b4e1fcb68a77")
    public String type;

    @objid ("91a7d683-0b65-476f-a25c-4590e873057e")
    public Emplacement(Integer idEmplacement, Integer ordonnee, Integer abscisse, String type) {
        super();
        this.idEmplacement = idEmplacement;
        this.ordonnee = ordonnee;
        this.abscisse = abscisse;
        this.type = type;
    }

    @objid ("85b8bc42-cdfd-4d8e-b8f1-8bc095f6a696")
    public Integer getIdEmplacement() {
        return idEmplacement;
    }

    @objid ("78cc7faf-a4de-43ea-a391-65158f5e6364")
    public void setIdEmplacement(Integer idEmplacement) {
        this.idEmplacement = idEmplacement;
    }

    @objid ("7f5e1f4c-147b-490d-a305-932302e548be")
    public Integer getOrdonnee() {
        return ordonnee;
    }

    @objid ("ede479c3-237a-4be0-8862-ba92e83bb9e9")
    public void setOrdonnee(Integer ordonnee) {
        this.ordonnee = ordonnee;
    }

    @objid ("f4986e55-0be8-4f12-b288-c930aa0701cd")
    public Integer getAbscisse() {
        return abscisse;
    }

    @objid ("b45b0064-b761-4560-a114-ba804cb3bfe0")
    public void setAbscisse(Integer abscisse) {
        this.abscisse = abscisse;
    }

    @objid ("201b7cde-a413-4d56-88be-c348e6856745")
    public String getType() {
        return type;
    }

    @objid ("b564a906-ca79-4585-9d27-25e43728fb8f")
    public void setType(String type) {
        this.type = type;
    }

}
