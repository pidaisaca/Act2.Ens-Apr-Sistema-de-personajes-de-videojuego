package interfaces;

 public interface Magica {
    default void lanzarHechizo(){
        System.out.println("Lanza un hechizo basico desde la interfaz magica");
    }
} 
