package pt.c02oo.s03project.s04ludo;

public class OpcaoVaziaException extends Exception{

    public OpcaoVaziaException() {
        super("Essa nao eh uma opcao valida");
    }

}
