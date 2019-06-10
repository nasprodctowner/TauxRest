package serviceTaux.dao;

import serviceTaux.modele.Taux;

import java.util.ArrayList;
import java.util.List;

public class TauxDAO {

    private static final ArrayList<Taux> tauxList = new ArrayList<Taux>();

    static {
        initTaux();
    }

    private static void initTaux() {
        Taux taux = new Taux(20,"dinar","euros",200);
        Taux taux2 = new Taux(21,"euros","dollars",400);
        tauxList.add(taux);
    }

    public static Taux getTaux(String monnaieA, String monnaieB) {
        for (Taux t : tauxList) {
            if (t.getMonnaieA().equals(monnaieA) && t.getMonnaieB().equals(monnaieB)) {
                return t;
            }
        }
        return null;
    }

    public static List<Taux> getAllTaux() {
        return tauxList;
    }

    public static float convertMonnaie(String monnaieA, String monnaieB, float montant) {
        float result = 0;
        for (Taux t : tauxList) {
            if (t.getMonnaieA().equals(monnaieA) && t.getMonnaieB().equals(monnaieB)) {
                result = t.getTaux() * montant;
            }
        }
        return result;
    }

    public static Taux createTaux(Taux taux) {
        tauxList.add(taux);
        return taux;
    }

    public static Taux updateTaux(Taux taux) {
        for (Taux t : tauxList) {
            if (t.getId() == taux.getId()) {
                t.setMonnaieA(taux.getMonnaieA());
                t.setMonnaieB(taux.getMonnaieB());
                t.setTaux(taux.getTaux());

                return t;
            }
        }
        return null;
    }


    //à corriger
    public static void deleteTaux(int id) {
        for (Taux t : tauxList) {
            if (t.getId() == id) {
                tauxList.remove(t);
            }
        }
    }
}
