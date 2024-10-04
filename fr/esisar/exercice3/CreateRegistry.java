package fr.esisar.exercice3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CreateRegistry {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(5050);

        System.out.println("Le registry est prêt ...");

        while (true) {
            Thread.sleep(100000); 
        }
    }
}
