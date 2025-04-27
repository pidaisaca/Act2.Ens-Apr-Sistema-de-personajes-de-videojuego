package interfaces;

public interface Curable {
    default void curar() {
        System.out.println("Lanzar un hechizo curativo");
    }
}
