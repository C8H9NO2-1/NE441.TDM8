package fr.esisar.exercice3;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class JeuImpl implements Jeu {

    private final int NOMBRE_TAS = 2;
    private final int NOMBRE_PION = 16;
    private List<Integer> jeu;
    private boolean first = true;
    private boolean end = false;

    public JeuImpl() {
        jeu = new ArrayList<>();
        for (int i = 0; i < NOMBRE_TAS; i++) {
            jeu.add(NOMBRE_PION);    
        }
    }

    @Override
    public List<Integer> etatJeu() throws RemoteException {
        return jeu;
    }

    @Override
    public String prendrePion(int nombrePion, int numeroTas) throws RemoteException {
        if (nombrePion > 3 || nombrePion <= 0) {
            return "Il faut prendre un nombre de pion correct (1-3)";
        }

        if (numeroTas <= jeu.size() && numeroTas > 0) {
            int i = numeroTas - 1;
            if (jeu.get(i) >= nombrePion) {
                jeu.set(i, jeu.get(i) - nombrePion);
                if (win()) {
                    end = true;
                    return "Vous avez gagné"; // The player has won
                }
                return "";
            } else {
                return "Il n'y a pas assez de pion";
            }
        }

        return "Le tas demandé n'existe pas";
    }

    public boolean isFinished() throws RemoteException {
        return end;
    }

    public boolean isFirst() throws RemoteException {
        return first;
    }

    public void setFirst(boolean first) throws RemoteException {
        this.first = first;
    }

    private boolean win() {
        for (Integer element: jeu) {
            if (element != 0) {
                return false;
            }
        }

        return true;
    }
}
