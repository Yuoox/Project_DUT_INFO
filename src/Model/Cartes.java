package Model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("227fd2e9-c590-4115-9e0c-d625870c0055")
public class Cartes {
    @objid ("ab2f083e-a8f3-4156-a8be-0f6ce2371bee")
    public Integer idCarte;

    @objid ("85506316-b3be-47aa-af08-b41637d93de4")
    public String Value;

    @objid ("8f188942-9d38-499e-8df1-8d8d3404c977")
    public String type;

    @objid ("b9d5c6f1-67d0-4da1-95aa-98d65999ed13")
    public int tourPioche;

    @objid ("5d1ff8a7-bfe5-4784-a6b5-aca0d7f8bd14")
    public Cartes(Integer idCarte, String value, String type) {
        super();
        this.idCarte = idCarte;
        Value = value;
        this.type = type;
    }

    @objid ("7233066f-ecc9-4fee-8860-a4e9425758e4")
    public Integer getIdCarte() {
        return idCarte;
    }

    @objid ("c718eea9-abe1-4841-9d65-b96e3d8fc4ff")
    public void setIdCarte(Integer idCarte) {
        this.idCarte = idCarte;
    }

    @objid ("d7377dc1-c71d-42c1-9c2d-02b7d2faeae9")
    public String getValue() {
        return Value;
    }

    @objid ("655167cd-a414-4184-b48e-623f48c159a2")
    public void setValue(String value) {
        Value = value;
    }

    @objid ("c2613de0-9d83-4a33-9d21-607064d24892")
    public String getType() {
        return type;
    }

    @objid ("f2397f93-633d-437d-8383-f119d10f5ecc")
    public void setType(String type) {
        this.type = type;
    }

    @objid ("1a763a45-dc66-4b9a-9d04-32f185db94cd")
    public Cartes Melange(Cartes paq) {
        // TODO Auto-generated return
        return paq;
    }

}
