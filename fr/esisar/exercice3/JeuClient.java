package fr.esisar.exercice3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class JeuClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 5050);

        Jeu stub = (Jeu) registry.lookup("jeu");

        System.out.println("Début du programme client");

        if (args.length != 1) {
            System.out.println("Il faut entrer un paramètre");
            return;
        }

        List<Integer> etat;
        int number = Integer.parseInt(args[0]);
        Scanner sc = new Scanner(System.in);

        boolean end = false;
        while (!end) {
            boolean first = stub.isFirst();
            if (number == 1 && first) {
                if (stub.isFinished()) {
                    System.out.println("\n====>> Vous avez perdu\n");
                    end = true;
                    continue;
                }
                System.out.println("\nC'est à vous de jouer");
                etat = stub.etatJeu();
                boolean b = true;
                while (b) {
                    System.out.println("État du jeu:");
                    for (int i = 0; i < etat.size(); i++) {
                        System.out.println("-> Tas " + (i + 1) + " =>> " + etat.get(i) + " pions");
                    }
                    System.out.println("Veuillez séléctionner le numéro du tas choisi (1-" + etat.size() + ")");
                    int numeroTas = sc.nextInt();

                    System.out.println("Veuillez séléctionner le nombre de pions à retirer (1-3)");
                    int nombrePion = sc.nextInt();

                    String reponse = stub.prendrePion(nombrePion, numeroTas);

                    if (reponse.equals("")) {
                        b = false;
                        stub.setFirst(!first);
                    } else if (reponse.equals("Vous avez gagné")) {
                        b = false;
                        end = true;
                        System.out.println("\n=====\nVous avez gagné\n=====\n"); 
                        stub.setFirst(!first);
                    } else {
                        System.out.println("\n==========");
                        System.out.println("=========>> " + reponse);
                        System.out.println("==========\n");
                    }
                }
            } else if (number == 2 && !first) {
                if (stub.isFinished()) {
                    System.out.println("\n====>> Vous avez perdu\n");
                    end = true;
                    continue;
                }
                System.out.println("\nC'est à vous de jouer");
                etat = stub.etatJeu();
                boolean b = true;
                while (b) {
                    System.out.println("État du jeu:");
                    for (int i = 0; i < etat.size(); i++) {
                        System.out.println("-> Tas " + (i + 1) + " =>> " + etat.get(i) + " pions");
                    }
                    System.out.println("Veuillez séléctionner le numéro du tas choisi (1-" + etat.size() + ")");
                    int numeroTas = sc.nextInt();

                    System.out.println("Veuillez séléctionner le nombre de pions à retirer (1-3)");
                    int nombrePion = sc.nextInt();

                    String reponse = stub.prendrePion(nombrePion, numeroTas);

                    if (reponse.equals("")) {
                        b = false;
                        stub.setFirst(!first);
                    } else if (reponse.equals("Vous avez gagné")) {
                        b = false;
                        end = true;
                        System.out.println("\n=====\nVous avez gagné\n=====\n"); 
                        stub.setFirst(!first);
                    } else {
                        System.out.println("\n==========");
                        System.out.println("=========>> " + reponse);
                        System.out.println("==========\n");
                    }
                }
            }
        }
    }
}
