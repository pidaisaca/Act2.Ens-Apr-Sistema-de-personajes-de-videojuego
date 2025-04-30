package model;

class Fisico extends Personaje {

    public Fisico(Nombre nombre, int nivel, int salud, int ataque, int defensa) {
        super(nombre, nivel, salud, ataque, defensa);
    }

    @Override
    public void atacar(Personaje enemigo, Personaje combatiente) {
        System.out.println("Ejecutando Ataque fisico");
        enemigo.setSalud(enemigo.getSalud() - combatiente.getAtaque());
        System.out.println(enemigo.getNombre() + " ha perdido " + combatiente.getAtaque() + " puntos de salud.");
        System.out.println(enemigo.getSalud());
        System.out.println(combatiente.getSalud());
    }

    @Override
    public void menuPersonaje(Personaje personaje, Personaje personaje2) {
    
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

class Magico extends Personaje {

    public Magico(Nombre nombre, int nivel, int salud, int ataque, int defensa) {
        super(nombre, nivel, salud, ataque, defensa);

    }


    @Override
    public void atacar(Personaje enemigo, Personaje combatiente) {
        System.out.println("Ejecutando ataque magico");
        enemigo.setSalud(enemigo.getSalud() - combatiente.getAtaque());
        System.out.println(enemigo.getNombre() + " ha perdido " + combatiente.getAtaque() + " puntos de salud.");
        System.out.println(enemigo.getSalud());
        System.out.println(combatiente.getSalud());
    }

    @Override
    public void menuPersonaje(Personaje personaje, Personaje personaje2) {
        
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
