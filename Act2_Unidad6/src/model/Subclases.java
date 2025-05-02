package model;

abstract class Fisico extends Personaje {

    public Fisico(Nombre nombre, int nivel, int salud, int saludMax, int ataque, int defensa) {
        super(nombre, nivel, salud, saludMax, ataque, defensa);
    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Ejecutando Ataque fisico");
        super.atacar(enemigo);

    }

    @Override
    public void atacarTipo() {
        System.out.println("Ataque fisico");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

abstract class  Magico extends Personaje {

    public Magico(Nombre nombre, int nivel, int salud, int saludMax, int ataque, int defensa) {
        super(nombre, nivel, salud, saludMax, ataque, defensa);

    }

    @Override
    public void atacar(Personaje enemigo) {
        System.out.println("Ejecutando ataque magico");
        super.atacar(enemigo);

    }



    @Override
    public void atacarTipo() {
        System.out.println("Ataque mágico");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
