package fr.esisar.exercice1;

import java.rmi.RemoteException;

public class CalculetteImpl implements Calculette {
    public int somme(int a, int b) throws RemoteException {
        System.out.println("Calcul de la somme de " + a + " et " + b);
        int c = a + b;
        return c;
    }

    public int difference(int a, int b) throws RemoteException {
        System.out.println("Calcul de la différence entre " + a + " et " + b);
        int c = a - b;
        return c;
    }
}
