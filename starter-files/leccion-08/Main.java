// Lección 8 - Práctica: Protege tus datos
// Reto: completa los TODO y ejecuta el programa.

public class Main {
    public static void main(String[] args) {
        Mascota perro = new Mascota();
        perro.nombre = "Firulais";
        perro.especie = "perro";
        perro.edad = -5; // ¡cualquiera puede poner una edad sin sentido!

        perro.presentarse();

        // TODO 4: cuando tengas el constructor, borra las 4 líneas de arriba
        // y crea la mascota en una sola línea:
        // Mascota perro = new Mascota("Firulais", "perro", 3);
        // y prueba setEdad(-5) y setEdad(4).
    }
}

class Mascota {
    // TODO 1: vuelve privados los atributos con private.
    String nombre;
    String especie;
    int edad;

    // TODO 2: agrega un constructor que reciba nombre, especie y edad.
    // Pista: se llama igual que la clase y usa this.nombre = nombre;

    // TODO 3: crea getNombre(), getEdad() y setEdad(int nuevaEdad).
    // setEdad solo debe aceptar edades mayores o iguales a 0.

    void presentarse() {
        System.out.println("Hola, soy " + nombre + ", un " + especie + " de " + edad + " años.");
    }
}
