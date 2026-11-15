// Lección 7 - Práctica: Tu propia mascota
// Reto: completa los TODO y ejecuta el programa.

public class Main {
    public static void main(String[] args) {
        Mascota perro = new Mascota();
        perro.nombre = "Firulais";
        perro.especie = "perro";
        perro.edad = 3;

        perro.presentarse();

        // TODO 1: crea una tercera mascota: tu mascota real o una inventada
        // (un loro, un hámster...). Usa new y llena sus atributos con el punto.

        // TODO 3: haz que tu nueva mascota se presente y juegue.
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

    // TODO 2: agrega un método jugar() que muestre, por ejemplo:
    // "Firulais está jugando con la pelota".
    // Pista: el método va dentro de la clase Mascota y se llama con el punto.
}
