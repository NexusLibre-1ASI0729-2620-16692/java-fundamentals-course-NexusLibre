// Lección 8: Constructores y encapsulación

public class Main {
    public static void main(String[] args) {
        Mascota perro = new Mascota("Firulais", "perro", 3);
        Mascota gato = new Mascota("Michi", "gato", 1);

        perro.presentarse();
        gato.presentarse();

        perro.setEdad(-5);
        perro.setEdad(4);
        System.out.println(perro.getNombre() + " ahora tiene " + perro.getEdad() + " años.");
    }
}

class Mascota {
    private String nombre;
    private String especie;
    private int edad;

    Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    String getNombre() {
        return nombre;
    }

    int getEdad() {
        return edad;
    }

    void setEdad(int nuevaEdad) {
        if (nuevaEdad >= 0) {
            edad = nuevaEdad;
        } else {
            System.out.println("Edad no válida: no puede ser negativa.");
        }
    }

    void presentarse() {
        System.out.println("Hola, soy " + nombre + ", un " + especie + " de " + edad + " años.");
    }
}
