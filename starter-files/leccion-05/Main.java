// Lección 5 - Práctica: Crea tu propio método
// Reto: completa los TODO y ejecuta el programa.

public class Main {
    public static void saludar(String nombre) {
        System.out.println("Hola, " + nombre + ", bienvenido al curso");
    }

    public static int sumar(int a, int b) {
        return a + b;
    }

    // TODO 1: crea el método despedir, que reciba un nombre
    // y muestre "Hasta luego" y ese nombre.

    // Reto extra: crea el método multiplicar, que reciba dos números
    // y devuelva su resultado.

    public static void main(String[] args) {
        saludar("Ana");

        int resultado = sumar(5, 3);
        System.out.println("La suma es: " + resultado);

        // TODO 2: llama a despedir con tu apodo.
    }
}
