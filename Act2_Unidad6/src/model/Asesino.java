package model;

class Asesino extends Fisico{
    double sigilo;
    double critico;
    public Asesino(String nombre, int nivel, int salud, int ataque, int defensa){
        super(nombre, nivel, salud, ataque, defensa);
    }
    void atacarPorLaEspalda(){
        System.out.println("Daño critico garantizado, requiere sigilo");
    }
    void ocultar(){
        System.out.println("Otorga sigilo");
    }
}
