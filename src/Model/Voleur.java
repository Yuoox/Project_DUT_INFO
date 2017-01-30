package Model;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("661b8cdc-b5af-4ef7-b2bc-4b778b450d8a")
public class Voleur {
    @objid ("799619d1-5f64-4849-9a91-30d5a4bf7a9b")
    public Emplacement emplacement;

    @objid ("0edd21cf-41aa-4f12-956a-3bfde0c8100e")
    public void changeEmpl() {
    }

    @objid ("3c0bd931-62c2-4bd3-936a-7771829cb68f")
    public void voler() {
    }

    @objid ("c0266147-d837-469f-8095-0972b52d0d40")
    public Voleur(Emplacement emplacement) {
        super();
        this.emplacement = emplacement;
    }

    @objid ("3c3eec9c-8d9d-4820-bad5-e814d72f882c")
    public Emplacement getEmplacement() {
        return emplacement;
    }

    @objid ("af3a3269-7eda-43a3-a442-097b5facc8e0")
    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    @objid ("9a9fca35-cbfe-4e0f-9377-c840e05c9092")
    public void Operation() {
    }

}
