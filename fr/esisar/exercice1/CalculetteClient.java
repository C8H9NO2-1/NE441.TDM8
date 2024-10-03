package fr.esisar.exercice1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculetteClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5050);

        Calculette stub = (Calculette) registry.lookup("calculette");

        System.out.println("Début du programme client");
        int a = 5;
        int b = 8;

        int c = stub.somme(a, b);

        System.out.println("Le résultat est " + c);
    }
}
