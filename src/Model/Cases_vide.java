package Model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("86371dd7-2aad-43ea-85aa-c403a99f54ed")
public class Cases_vide {
    @objid ("dcb69c60-48c3-4aa1-8956-093d2a08c671")
    public Integer idCase;

    @objid ("00abb015-2712-434b-8d74-d1dc62b0fd10")
    public String type;

    @objid ("65352817-a2c8-4e0b-9ff7-627d9e8149b0")
    public Cases_vide(Integer idCase, String type) {
        super();
        this.idCase = idCase;
        this.type = type;
    }

    @objid ("8fe28270-0fcc-4d45-9cf0-d3ff069cd1fd")
    public Integer getIdCase() {
        return idCase;
    }

    @objid ("94a4e988-6ab3-4200-9b03-b51de8ca9e0b")
    public void setIdCase(Integer idCase) {
        this.idCase = idCase;
    }

    @objid ("a988ae28-6dec-489a-9025-109c428d0e29")
    public String getType() {
        return type;
    }

    @objid ("a0862501-c0d6-4fd4-9402-c3fa2834cc93")
    public void setType(String type) {
        this.type = type;
    }

}
