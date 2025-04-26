package interfaces;

public interface Volador {
    default void volar(){
        System.out.println("Alza el vuelo y aumenta la evasion contra ataques fisicos cuerpo a cuerpo");
    }
}
