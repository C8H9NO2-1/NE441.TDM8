package fr.esisar.exercice1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculetteServer {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.rmi.server.hostname", "192.168.1.12");

        CalculetteImpl calculetteImpl = new CalculetteImpl();

        Calculette skeleton = (Calculette) UnicastRemoteObject.exportObject(calculetteImpl, 7070);

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5050);

        registry.bind("calculette", skeleton);

        System.out.println("Le serveur est prêt ...");
    }
}
