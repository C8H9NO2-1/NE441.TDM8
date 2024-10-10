package fr.esisar.exercice3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class JeuServer {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.rmi.server.hostname", "127.0.0.1");

        JeuImpl jeuImpl = new JeuImpl();

        Jeu skeleton = (Jeu) UnicastRemoteObject.exportObject(jeuImpl, 7070);

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5050);

        registry.bind("jeu", skeleton);

        System.out.println("Le serveur est prêt ...");
    }
}
