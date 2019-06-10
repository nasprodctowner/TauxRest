package serviceTaux.modele;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "taux")
@XmlAccessorType(XmlAccessType.FIELD)
public class Taux {


    private int id ;
    private String monnaieA, monnaieB;
    private float taux;

    public Taux() {
    }

    public Taux(int id, String monnaieA, String monnaieB, float taux) {
        this.id = id;
        this.monnaieA = monnaieA;
        this.monnaieB = monnaieB;
        this.taux = taux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonnaieA() {
        return monnaieA;
    }

    public void setMonnaieA(String monnaieA) {
        this.monnaieA = monnaieA;
    }

    public String getMonnaieB() {
        return monnaieB;
    }

    public void setMonnaieB(String monnaieB) {
        this.monnaieB = monnaieB;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }
}
