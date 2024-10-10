package fr.esisar.exercice3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Jeu extends Remote {
    public List<Integer> etatJeu() throws RemoteException;
    public String prendrePion(int nombrePion, int numeroTas) throws RemoteException;
    public boolean isFinished() throws RemoteException;
    public boolean isFirst() throws RemoteException;
    public void setFirst(boolean first) throws RemoteException;
}
