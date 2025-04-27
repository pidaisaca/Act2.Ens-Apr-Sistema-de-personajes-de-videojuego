package interfaces;

 public interface Defendible {
    default void defender() {
        System.out.println("Reduce el daño recibido en un 50% (Heredado de Defendible)");
    }
}
