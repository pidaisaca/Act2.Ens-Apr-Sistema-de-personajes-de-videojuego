package model;

class Subclases extends Personaje {

    public Subclases(String nombre, int nivel, int salud, int ataque, int defensa) {
        super(nombre, nivel, salud, ataque, defensa);
    }

    @Override
    public void atacar() {
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

class Magico extends Personaje {

    public Magico(String nombre, int nivel, int salud, int ataque, int defensa) {
        super(nombre, nivel, salud, ataque, defensa);
    }

    @Override
    public void atacar() {
        System.out.println("Ataque magico");
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
