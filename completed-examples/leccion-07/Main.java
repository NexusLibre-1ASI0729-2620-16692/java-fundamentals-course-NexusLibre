// Lección 7: Introducción a POO: clases y objetos

public class Main {
    public static void main(String[] args) {
        Mascota perro = new Mascota();
        perro.nombre = "Firulais";
        perro.especie = "perro";
        perro.edad = 3;

        Mascota gato = new Mascota();
        gato.nombre = "Michi";
        gato.especie = "gato";
        gato.edad = 1;

        perro.presentarse();
        gato.presentarse();
        gato.cumplirAnios();
    }
}

class Mascota {
    String nombre;
    String especie;
    int edad;

    void presentarse() {
        System.out.println("Hola, soy " + nombre + ", un " + especie + " de " + edad + " años.");
    }

    void cumplirAnios() {
        edad = edad + 1;
        System.out.println("¡" + nombre + " cumplió años! Ahora tiene " + edad + ".");
    }
}
