package model;

class Mago extends Magico{
    int mana;
    int Sabiduria;
    public Mago(String nombre, int nivel, int salud, int ataque, int defensa){
        super(nombre, nivel, salud, ataque, defensa);
    }
    void lanzarHechizo(){
        System.out.println("Inflige daño magico");
    }
    void regenerarMana(){
        System.out.println("Regenera una gran cantidad de mana");
    }
}
