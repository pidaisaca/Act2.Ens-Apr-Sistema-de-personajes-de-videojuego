package model;

class Arquero extends Fisico{
    double agilidad;
    int numFlechas;
    public Arquero(String nombre, int nivel, int salud, int ataque, int defensa){
        super(nombre, nivel, salud, ataque, defensa);

    }
    void restablecerFlechas(){
        System.out.println("Restablecer flechas");
    }

    void dispararFlechas(){
        System.out.println("Gasta flechas para infligir daño fisico a distancia");
    }

}