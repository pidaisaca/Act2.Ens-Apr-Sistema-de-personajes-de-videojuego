package interfaces;

public interface  Movilizable {
    default void moverse(){
        System.out.println("Se desplaza a una posicion segura");
    }
}
