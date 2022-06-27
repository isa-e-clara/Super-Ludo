package pt.c02oo.s03project.s04ludo;

public interface Observed {

    public void registrar(Observer obj);
    public void notificarObservadores();
    
}
