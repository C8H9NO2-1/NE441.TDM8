package fr.esisar.exercice3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class JeuClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("192.168.1.12", 5050);

        Jeu stub = (Jeu) registry.lookup("jeu");

        System.out.println("Début du programme client");



    }
}
