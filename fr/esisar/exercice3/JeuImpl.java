package fr.esisar.exercice3;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class JeuImpl implements Jeu {

    private final int NOMBRE_TAS = 1;
    private final int NOMBRE_PION = 16;
    private List<Integer> jeu;

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
    public boolean prendrePion(int nombrePion, int numeroTas) throws RemoteException {
        // This method returns true if the player has won
        if (nombrePion > 3 || nombrePion <= 0) {
            System.out.println("Le joueur ne sait pas jouer");
            return false;
        }

        if (numeroTas <= jeu.size() && numeroTas > 0) {
            int i = numeroTas - 1;
            if (jeu.get(i) <= nombrePion) {
                jeu.set(i, jeu.get(i) - nombrePion);
                // TODO => Modify this part if we want more than one game in parallel
                if (jeu.get(i) == 0) {
                    return true; // The player has won
                }
            }
        }

        System.out.println("Le joueur ne sait pas jouer");
        return false;
    }
}
