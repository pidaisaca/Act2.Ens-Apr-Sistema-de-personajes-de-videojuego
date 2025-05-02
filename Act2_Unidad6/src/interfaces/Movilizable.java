package interfaces;

// Interface Movilizable que se implementa en las clases guerrero y mago
public interface  Movilizable {
    default void moverse(){
        System.out.println("Se desplaza a una posicion segura");
    }
}
