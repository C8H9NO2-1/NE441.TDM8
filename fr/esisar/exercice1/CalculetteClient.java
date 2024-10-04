package fr.esisar.exercice1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculetteClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("192.168.1.12", 5050);

        Calculette stub = (Calculette) registry.lookup("calculette");

        System.out.println("Début du programme client");
        int a = 5;
        int b = 8;

        int c = stub.somme(a, b);

        int d = stub.difference(a, b);

        System.out.println("Le résultat est " + c);
        System.out.println("Le résultat est " + d);
    }
}
